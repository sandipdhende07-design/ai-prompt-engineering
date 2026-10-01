package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProgressDao {

    // Lesson Progress
    @Query("SELECT * FROM lesson_progress")
    fun getAllLessonProgress(): Flow<List<LessonProgressEntity>>

    @Query("SELECT * FROM lesson_progress WHERE lessonId = :lessonId LIMIT 1")
    suspend fun getLessonProgress(lessonId: String): LessonProgressEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLessonProgress(progress: LessonProgressEntity)

    @Query("DELETE FROM lesson_progress")
    suspend fun clearAllLessonProgress()

    // Quiz Results
    @Query("SELECT * FROM quiz_results")
    fun getAllQuizResults(): Flow<List<QuizResultEntity>>

    @Query("SELECT * FROM quiz_results WHERE quizId = :quizId LIMIT 1")
    suspend fun getQuizResult(quizId: String): QuizResultEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveQuizResult(result: QuizResultEntity)

    @Query("DELETE FROM quiz_results")
    suspend fun clearAllQuizResults()

    // Saved Prompts
    @Query("SELECT * FROM saved_prompts ORDER BY createdAt DESC")
    fun getAllSavedPrompts(): Flow<List<SavedPromptEntity>>

    @Query("SELECT * FROM saved_prompts WHERE isFavorite = 1 ORDER BY createdAt DESC")
    fun getFavoritePrompts(): Flow<List<SavedPromptEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavedPrompt(prompt: SavedPromptEntity): Long

    @Update
    suspend fun updateSavedPrompt(prompt: SavedPromptEntity)

    @Query("DELETE FROM saved_prompts WHERE id = :id")
    suspend fun deleteSavedPromptById(id: Long)

    @Query("UPDATE saved_prompts SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun toggleFavoritePrompt(id: Long, isFavorite: Boolean)

    // Practice Submissions
    @Query("SELECT * FROM practice_submissions")
    fun getAllPracticeSubmissions(): Flow<List<PracticeSubmissionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePracticeSubmission(submission: PracticeSubmissionEntity)

    @Query("DELETE FROM practice_submissions")
    suspend fun clearAllPracticeSubmissions()

    // User Settings & Stats
    @Query("SELECT * FROM user_settings WHERE id = 1 LIMIT 1")
    fun getUserSettingsFlow(): Flow<UserSettingsEntity?>

    @Query("SELECT * FROM user_settings WHERE id = 1 LIMIT 1")
    suspend fun getUserSettings(): UserSettingsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserSettings(settings: UserSettingsEntity)

    @Query("UPDATE user_settings SET onboardingCompleted = 1 WHERE id = 1")
    suspend fun markOnboardingCompleted()

    @Query("UPDATE user_settings SET darkMode = :mode WHERE id = 1")
    suspend fun updateDarkMode(mode: String)

    @Query("UPDATE user_settings SET studentName = :name WHERE id = 1")
    suspend fun updateStudentName(name: String)

    @Query("UPDATE user_settings SET certificateIssuedDate = :date WHERE id = 1")
    suspend fun issueCertificate(date: String)
}
