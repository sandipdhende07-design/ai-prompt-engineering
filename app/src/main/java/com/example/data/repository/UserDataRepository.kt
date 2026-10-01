package com.example.data.repository

import com.example.data.local.LessonProgressEntity
import com.example.data.local.PracticeSubmissionEntity
import com.example.data.local.ProgressDao
import com.example.data.local.QuizResultEntity
import com.example.data.local.SavedPromptEntity
import com.example.data.local.UserSettingsEntity
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UserDataRepository(private val dao: ProgressDao) {

    val allLessonProgress: Flow<List<LessonProgressEntity>> = dao.getAllLessonProgress()
    val allQuizResults: Flow<List<QuizResultEntity>> = dao.getAllQuizResults()
    val allSavedPrompts: Flow<List<SavedPromptEntity>> = dao.getAllSavedPrompts()
    val favoritePrompts: Flow<List<SavedPromptEntity>> = dao.getFavoritePrompts()
    val userSettings: Flow<UserSettingsEntity?> = dao.getUserSettingsFlow()

    suspend fun initDefaultUserIfEmpty() {
        val current = dao.getUserSettings()
        if (current == null) {
            val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            dao.saveUserSettings(
                UserSettingsEntity(
                    id = 1,
                    studentName = "Prompt Engineer",
                    darkMode = "system",
                    onboardingCompleted = false,
                    streakDays = 1,
                    lastActiveDate = today
                )
            )
        }
    }

    suspend fun markLessonCompleted(lessonId: String, moduleId: String) {
        dao.saveLessonProgress(
            LessonProgressEntity(
                lessonId = lessonId,
                moduleId = moduleId,
                isCompleted = true,
                completedAt = System.currentTimeMillis()
            )
        )
        updateStreak()
    }

    suspend fun saveQuizResult(quizId: String, score: Int, total: Int) {
        val percentage = if (total > 0) ((score.toFloat() / total) * 100).toInt() else 0
        val passed = percentage >= 70
        dao.saveQuizResult(
            QuizResultEntity(
                quizId = quizId,
                score = score,
                totalQuestions = total,
                percentage = percentage,
                passed = passed,
                attemptedAt = System.currentTimeMillis()
            )
        )
        updateStreak()
    }

    suspend fun savePrompt(title: String, category: String, promptText: String): Long {
        return dao.insertSavedPrompt(
            SavedPromptEntity(
                title = title,
                category = category,
                promptText = promptText,
                isFavorite = false,
                createdAt = System.currentTimeMillis()
            )
        )
    }

    suspend fun toggleFavorite(promptId: Long, currentFavorite: Boolean) {
        dao.toggleFavoritePrompt(promptId, !currentFavorite)
    }

    suspend fun deleteSavedPrompt(promptId: Long) {
        dao.deleteSavedPromptById(promptId)
    }

    suspend fun recordPracticeSubmission(challengeId: String, userPrompt: String, score: Int) {
        dao.savePracticeSubmission(
            PracticeSubmissionEntity(
                challengeId = challengeId,
                userPrompt = userPrompt,
                overallScore = score,
                completedAt = System.currentTimeMillis()
            )
        )
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val current = dao.getUserSettings()
        if (current != null) {
            dao.saveUserSettings(current.copy(dailyPracticeCompletedDate = today))
        }
        updateStreak()
    }

    suspend fun completeOnboarding() {
        dao.markOnboardingCompleted()
    }

    suspend fun updateDarkMode(mode: String) {
        dao.updateDarkMode(mode)
    }

    suspend fun updateStudentName(name: String) {
        dao.updateStudentName(name)
    }

    suspend fun issueCertificate(dateStr: String) {
        dao.issueCertificate(dateStr)
    }

    suspend fun resetAllProgress() {
        dao.clearAllLessonProgress()
        dao.clearAllQuizResults()
        dao.clearAllPracticeSubmissions()
        val current = dao.getUserSettings()
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        if (current != null) {
            dao.saveUserSettings(
                current.copy(
                    streakDays = 1,
                    dailyPracticeCompletedDate = "",
                    certificateIssuedDate = null,
                    lastActiveDate = today
                )
            )
        }
    }

    private suspend fun updateStreak() {
        val current = dao.getUserSettings() ?: return
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        if (current.lastActiveDate.isEmpty()) {
            dao.saveUserSettings(current.copy(lastActiveDate = today, streakDays = 1))
        } else if (current.lastActiveDate != today) {
            // Check if streak continues or resets
            val diffDays = calculateDayDiff(current.lastActiveDate, today)
            val newStreak = if (diffDays == 1L) current.streakDays + 1 else if (diffDays > 1L) 1 else current.streakDays
            dao.saveUserSettings(current.copy(lastActiveDate = today, streakDays = newStreak))
        }
    }

    private fun calculateDayDiff(date1: String, date2: String): Long {
        return try {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val d1 = format.parse(date1)
            val d2 = format.parse(date2)
            if (d1 != null && d2 != null) {
                val diff = d2.time - d1.time
                diff / (1000 * 60 * 60 * 24)
            } else 0L
        } catch (_: Exception) {
            0L
        }
    }
}
