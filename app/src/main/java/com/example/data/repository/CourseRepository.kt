package com.example.data.repository

import com.example.data.content.CourseData
import com.example.data.content.PracticeData
import com.example.data.content.ProjectsData
import com.example.data.content.PromptLibraryData
import com.example.data.content.QuizData
import com.example.data.model.CourseModule
import com.example.data.model.Lesson
import com.example.data.model.PracticeChallenge
import com.example.data.model.PromptTemplate
import com.example.data.model.Quiz
import com.example.data.model.RealWorldProject

class CourseRepository {

    val modules: List<CourseModule> = CourseData.modules
    val totalLessonsCount: Int = CourseData.totalLessonsCount
    val practiceChallenges: List<PracticeChallenge> = PracticeData.challenges
    val promptTemplates: List<PromptTemplate> = PromptLibraryData.templates
    val realWorldProjects: List<RealWorldProject> = ProjectsData.projects

    fun getModule(moduleId: String): CourseModule? = CourseData.getModule(moduleId)

    fun getLesson(lessonId: String): Lesson? = CourseData.getLesson(lessonId)

    fun getNextLesson(currentLessonId: String): Lesson? = CourseData.getNextLesson(currentLessonId)

    fun getPreviousLesson(currentLessonId: String): Lesson? = CourseData.getPreviousLesson(currentLessonId)

    fun getQuiz(quizId: String): Quiz? = QuizData.getQuiz(quizId)

    fun getPracticeChallenge(challengeId: String): PracticeChallenge? = PracticeData.getChallenge(challengeId)

    fun getProject(projectId: String): RealWorldProject? = ProjectsData.getProject(projectId)

    fun searchAll(query: String): SearchResults {
        if (query.isBlank()) return SearchResults(emptyList(), emptyList(), emptyList())
        val q = query.trim().lowercase()

        val matchedLessons = CourseData.searchLessons(q)
        val matchedPrompts = PromptLibraryData.searchPrompts(q)
        val matchedProjects = realWorldProjects.filter {
            it.title.lowercase().contains(q) ||
                it.domain.lowercase().contains(q) ||
                it.objective.lowercase().contains(q)
        }

        return SearchResults(matchedLessons, matchedPrompts, matchedProjects)
    }
}

data class SearchResults(
    val lessons: List<Lesson>,
    val prompts: List<PromptTemplate>,
    val projects: List<RealWorldProject>
)
