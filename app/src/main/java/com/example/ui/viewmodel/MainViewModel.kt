package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.evaluator.PromptEvaluator
import com.example.data.local.AppDatabase
import com.example.data.local.LessonProgressEntity
import com.example.data.local.QuizResultEntity
import com.example.data.local.SavedPromptEntity
import com.example.data.local.UserSettingsEntity
import com.example.data.model.AchievementBadge
import com.example.data.model.CourseModule
import com.example.data.model.Lesson
import com.example.data.model.PromptHeuristicScore
import com.example.data.repository.CourseRepository
import com.example.data.repository.UserDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class MainUiState(
    val userSettings: UserSettingsEntity = UserSettingsEntity(),
    val completedLessonIds: Set<String> = emptySet(),
    val quizResults: Map<String, QuizResultEntity> = emptyMap(),
    val savedPrompts: List<SavedPromptEntity> = emptyList(),
    val completedCount: Int = 0,
    val totalCount: Int = 0,
    val progressPercent: Int = 0,
    val currentLesson: Lesson? = null,
    val achievements: List<AchievementBadge> = emptyList(),
    val isCertificateEligible: Boolean = false
)

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getDatabase(application)
    val courseRepository = CourseRepository()
    val userDataRepository = UserDataRepository(db.progressDao())

    init {
        viewModelScope.launch {
            userDataRepository.initDefaultUserIfEmpty()
        }
    }

    val uiState: StateFlow<MainUiState> = combine(
        userDataRepository.userSettings,
        userDataRepository.allLessonProgress,
        userDataRepository.allQuizResults,
        userDataRepository.allSavedPrompts
    ) { settings, lessons, quizzes, savedPrompts ->
        val user = settings ?: UserSettingsEntity()
        val completedSet = lessons.filter { it.isCompleted }.map { it.lessonId }.toSet()
        val quizMap = quizzes.associateBy { it.quizId }
        val total = courseRepository.totalLessonsCount
        val completed = completedSet.size
        val percent = if (total > 0) ((completed.toFloat() / total) * 100).toInt().coerceIn(0, 100) else 0

        // Find next incomplete lesson
        var nextLesson: Lesson? = null
        for (module in courseRepository.modules) {
            for (lesson in module.lessons) {
                if (!completedSet.contains(lesson.id)) {
                    nextLesson = lesson
                    break
                }
            }
            if (nextLesson != null) break
        }
        if (nextLesson == null) {
            nextLesson = courseRepository.modules.firstOrNull()?.lessons?.firstOrNull()
        }

        // Calculate badges
        val hasPassedQuiz = quizzes.any { it.passed }
        val finalQuizPassed = quizMap["final_assessment"]?.passed == true
        val isCertEligible = (percent >= 75 || completed >= 12) && hasPassedQuiz

        val badges = listOf(
            AchievementBadge(
                id = "badge_1",
                title = "First Step",
                description = "Complete your very first lesson",
                iconName = "CheckCircle",
                isUnlocked = completed >= 1,
                progressText = "$completed / 1"
            ),
            AchievementBadge(
                id = "badge_2",
                title = "Prompt Beginner",
                description = "Complete 3 course lessons",
                iconName = "School",
                isUnlocked = completed >= 3,
                progressText = "$completed / 3"
            ),
            AchievementBadge(
                id = "badge_3",
                title = "Prompt Explorer",
                description = "Complete 5 course lessons",
                iconName = "Explore",
                isUnlocked = completed >= 5,
                progressText = "$completed / 5"
            ),
            AchievementBadge(
                id = "badge_4",
                title = "10 Lessons Completed",
                description = "Complete 10 course lessons",
                iconName = "WorkspacePremium",
                isUnlocked = completed >= 10,
                progressText = "$completed / 10"
            ),
            AchievementBadge(
                id = "badge_5",
                title = "Quiz Master",
                description = "Pass a module quiz with a high score",
                iconName = "Quiz",
                isUnlocked = hasPassedQuiz,
                progressText = if (hasPassedQuiz) "Unlocked" else "Pending"
            ),
            AchievementBadge(
                id = "badge_6",
                title = "Practice Streak",
                description = "Maintain a daily learning streak of 2+ days",
                iconName = "Whatshot",
                isUnlocked = user.streakDays >= 2,
                progressText = "${user.streakDays} / 2 days"
            ),
            AchievementBadge(
                id = "badge_7",
                title = "Prompt Architect",
                description = "Save 2 or more custom prompts to your library",
                iconName = "Bookmark",
                isUnlocked = savedPrompts.size >= 2,
                progressText = "${savedPrompts.size} / 2 saved"
            ),
            AchievementBadge(
                id = "badge_8",
                title = "Course Master",
                description = "Pass the Final Certification Assessment",
                iconName = "Stars",
                isUnlocked = finalQuizPassed,
                progressText = if (finalQuizPassed) "Mastered" else "Exam required"
            )
        )

        MainUiState(
            userSettings = user,
            completedLessonIds = completedSet,
            quizResults = quizMap,
            savedPrompts = savedPrompts,
            completedCount = completed,
            totalCount = total,
            progressPercent = percent,
            currentLesson = nextLesson,
            achievements = badges,
            isCertificateEligible = isCertEligible
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MainUiState()
    )

    fun completeLesson(lessonId: String, moduleId: String) {
        viewModelScope.launch {
            userDataRepository.markLessonCompleted(lessonId, moduleId)
        }
    }

    fun submitQuiz(quizId: String, score: Int, total: Int) {
        viewModelScope.launch {
            userDataRepository.saveQuizResult(quizId, score, total)
        }
    }

    fun savePrompt(title: String, category: String, promptText: String, onComplete: ((Long) -> Unit)? = null) {
        viewModelScope.launch {
            val id = userDataRepository.savePrompt(title, category, promptText)
            onComplete?.invoke(id)
        }
    }

    fun toggleFavorite(promptId: Long, current: Boolean) {
        viewModelScope.launch {
            userDataRepository.toggleFavorite(promptId, current)
        }
    }

    fun deletePrompt(promptId: Long) {
        viewModelScope.launch {
            userDataRepository.deleteSavedPrompt(promptId)
        }
    }

    fun submitPractice(challengeId: String, prompt: String, score: Int) {
        viewModelScope.launch {
            userDataRepository.recordPracticeSubmission(challengeId, prompt, score)
        }
    }

    fun completeOnboarding() {
        viewModelScope.launch {
            userDataRepository.completeOnboarding()
        }
    }

    fun setDarkMode(mode: String) {
        viewModelScope.launch {
            userDataRepository.updateDarkMode(mode)
        }
    }

    fun setStudentName(name: String) {
        viewModelScope.launch {
            userDataRepository.updateStudentName(name)
        }
    }

    fun claimCertificate() {
        viewModelScope.launch {
            val dateStr = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()).format(Date())
            userDataRepository.issueCertificate(dateStr)
        }
    }

    fun resetAllProgress() {
        viewModelScope.launch {
            userDataRepository.resetAllProgress()
        }
    }

    fun analyzePrompt(
        prompt: String,
        role: String = "",
        context: String = "",
        constraints: String = "",
        outputFormat: String = "",
        examples: String = ""
    ): PromptHeuristicScore {
        return PromptEvaluator.evaluatePrompt(
            prompt = prompt,
            role = role,
            context = context,
            constraints = constraints,
            outputFormat = outputFormat,
            examples = examples
        )
    }
}
