package com.example.ui.navigation

sealed class Screen(val route: String) {
    object Onboarding : Screen("onboarding")
    object Home : Screen("home")
    object Course : Screen("course")
    object ModuleDetail : Screen("module/{moduleId}") {
        fun createRoute(moduleId: String) = "module/$moduleId"
    }
    object LessonDetail : Screen("lesson/{lessonId}") {
        fun createRoute(lessonId: String) = "lesson/$lessonId"
    }
    object Practice : Screen("practice")
    object Playground : Screen("playground")
    object Library : Screen("library")
    object Quiz : Screen("quiz/{quizId}") {
        fun createRoute(quizId: String) = "quiz/$quizId"
    }
    object Projects : Screen("projects")
    object Certificate : Screen("certificate")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
    object Search : Screen("search")
}
