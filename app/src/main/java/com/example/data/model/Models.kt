package com.example.data.model

data class CourseModule(
    val id: String,
    val number: Int,
    val title: String,
    val subtitle: String,
    val description: String,
    val iconName: String,
    val lessons: List<Lesson>,
    val quizId: String? = null
)

data class Lesson(
    val id: String,
    val moduleId: String,
    val number: Int,
    val title: String,
    val readingTimeMinutes: Int,
    val objectives: List<String>,
    val explanation: String,
    val badPrompt: String? = null,
    val improvedPrompt: String? = null,
    val whyImproved: String? = null,
    val keyPoints: List<String>,
    val miniExercise: String,
    val miniExerciseHint: String? = null
)

data class QuizQuestion(
    val id: String,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class Quiz(
    val id: String,
    val moduleId: String,
    val title: String,
    val description: String,
    val questions: List<QuizQuestion>,
    val passPercentage: Int = 70
)

data class PromptTemplate(
    val id: String,
    val title: String,
    val category: String,
    val description: String,
    val prompt: String,
    val framework: String? = null,
    val tags: List<String> = emptyList(),
    val isFeatured: Boolean = false
)

data class PracticeChallenge(
    val id: String,
    val title: String,
    val category: String,
    val difficulty: String, // Beginner, Intermediate, Advanced
    val scenario: String,
    val task: String,
    val sampleGoodPrompt: String,
    val criteria: List<String>
)

data class RealWorldProject(
    val id: String,
    val title: String,
    val domain: String,
    val objective: String,
    val requirements: List<String>,
    val startingPrompt: String,
    val improvementSteps: List<String>,
    val finalPrompt: String,
    val challenge: String,
    val expectedResult: String
)

data class PromptHeuristicScore(
    val clarityScore: Int,      // 0 - 100
    val contextScore: Int,      // 0 - 100
    val specificityScore: Int,  // 0 - 100
    val constraintsScore: Int,  // 0 - 100
    val outputFormatScore: Int, // 0 - 100
    val overallScore: Int,      // 0 - 100
    val strengths: List<String>,
    val suggestions: List<String>,
    val suggestedRevision: String
)

data class AchievementBadge(
    val id: String,
    val title: String,
    val description: String,
    val iconName: String,
    val isUnlocked: Boolean = false,
    val progressText: String = ""
)
