package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson_progress")
data class LessonProgressEntity(
    @PrimaryKey val lessonId: String,
    val moduleId: String,
    val isCompleted: Boolean,
    val completedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "quiz_results")
data class QuizResultEntity(
    @PrimaryKey val quizId: String,
    val score: Int,
    val totalQuestions: Int,
    val percentage: Int,
    val passed: Boolean,
    val attemptedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "saved_prompts")
data class SavedPromptEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val category: String,
    val promptText: String,
    val isFavorite: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "practice_submissions")
data class PracticeSubmissionEntity(
    @PrimaryKey val challengeId: String,
    val userPrompt: String,
    val overallScore: Int,
    val completedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "user_settings")
data class UserSettingsEntity(
    @PrimaryKey val id: Int = 1,
    val studentName: String = "Alex Chen",
    val darkMode: String = "system", // "system", "dark", "light"
    val onboardingCompleted: Boolean = false,
    val streakDays: Int = 1,
    val lastActiveDate: String = "",
    val dailyPracticeCompletedDate: String = "",
    val certificateIssuedDate: String? = null
)
