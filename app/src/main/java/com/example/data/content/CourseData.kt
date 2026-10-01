package com.example.data.content

import com.example.data.model.CourseModule
import com.example.data.model.Lesson

object CourseData {

    val modules: List<CourseModule> = listOf(
        CourseModules1To6.module1,
        CourseModules1To6.module2,
        CourseModules1To6.module3,
        CourseModules1To6.module4,
        CourseModules1To6.module5,
        CourseModules1To6.module6,
        CourseModules7To12.module7,
        CourseModules7To12.module8,
        CourseModules7To12.module9,
        CourseModules7To12.module10,
        CourseModules7To12.module11,
        CourseModules7To12.module12,
        CourseModules13To18.module13,
        CourseModules13To18.module14,
        CourseModules13To18.module15,
        CourseModules13To18.module16,
        CourseModules13To18.module17,
        CourseModules13To18.module18
    )

    val totalLessonsCount: Int = modules.sumOf { it.lessons.size }

    fun getModule(moduleId: String): CourseModule? {
        return modules.find { it.id == moduleId }
    }

    fun getLesson(lessonId: String): Lesson? {
        for (module in modules) {
            val lesson = module.lessons.find { it.id == lessonId }
            if (lesson != null) return lesson
        }
        return null
    }

    fun getNextLesson(currentLessonId: String): Lesson? {
        var foundCurrent = false
        for (module in modules) {
            for (lesson in module.lessons) {
                if (foundCurrent) {
                    return lesson
                }
                if (lesson.id == currentLessonId) {
                    foundCurrent = true
                }
            }
        }
        return null
    }

    fun getPreviousLesson(currentLessonId: String): Lesson? {
        var prev: Lesson? = null
        for (module in modules) {
            for (lesson in module.lessons) {
                if (lesson.id == currentLessonId) {
                    return prev
                }
                prev = lesson
            }
        }
        return null
    }

    fun searchLessons(query: String): List<Lesson> {
        if (query.isBlank()) return emptyList()
        val q = query.trim().lowercase()
        return modules.flatMap { it.lessons }.filter { lesson ->
            lesson.title.lowercase().contains(q) ||
                lesson.explanation.lowercase().contains(q) ||
                lesson.keyPoints.any { it.lowercase().contains(q) } ||
                (lesson.badPrompt?.lowercase()?.contains(q) == true) ||
                (lesson.improvedPrompt?.lowercase()?.contains(q) == true)
        }
    }
}
