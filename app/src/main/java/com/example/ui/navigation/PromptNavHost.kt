package com.example.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.screens.CertificateScreen
import com.example.ui.screens.CourseScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LessonDetailScreen
import com.example.ui.screens.LibraryScreen
import com.example.ui.screens.ModuleDetailScreen
import com.example.ui.screens.OnboardingScreen
import com.example.ui.screens.PlaygroundScreen
import com.example.ui.screens.PracticeScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.screens.ProjectsScreen
import com.example.ui.screens.QuizScreen
import com.example.ui.screens.SearchScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.viewmodel.MainViewModel

enum class BottomTab {
    HOME, COURSE, PRACTICE, PLAYGROUND, LIBRARY, PROFILE
}

sealed class CurrentScreen {
    data class Tab(val tab: BottomTab) : CurrentScreen()
    data class ModuleDetail(val moduleId: String) : CurrentScreen()
    data class LessonDetail(val lessonId: String) : CurrentScreen()
    data class Quiz(val quizId: String) : CurrentScreen()
    object Projects : CurrentScreen()
    object Certificate : CurrentScreen()
    object Settings : CurrentScreen()
    object Search : CurrentScreen()
}

@Composable
fun PromptNavHost(
    viewModel: MainViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var currentScreen by remember { mutableStateOf<CurrentScreen>(CurrentScreen.Tab(BottomTab.HOME)) }
    val screenStack = remember { mutableListOf<CurrentScreen>() }

    fun navigateTo(screen: CurrentScreen) {
        screenStack.add(currentScreen)
        currentScreen = screen
    }

    fun navigateBack() {
        if (screenStack.isNotEmpty()) {
            currentScreen = screenStack.removeAt(screenStack.size - 1)
        } else {
            currentScreen = CurrentScreen.Tab(BottomTab.HOME)
        }
    }

    // Onboarding Check
    if (!uiState.userSettings.onboardingCompleted) {
        OnboardingScreen(
            onFinished = {
                viewModel.completeOnboarding()
            }
        )
        return
    }

    val isTopLevelTab = currentScreen is CurrentScreen.Tab
    val currentTab = (currentScreen as? CurrentScreen.Tab)?.tab

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isTopLevelTab) {
                NavigationBar(
                    modifier = Modifier
                        .windowInsetsPadding(WindowInsets.navigationBars)
                        .testTag("main_bottom_nav_bar")
                ) {
                    NavigationBarItem(
                        selected = currentTab == BottomTab.HOME,
                        onClick = { currentScreen = CurrentScreen.Tab(BottomTab.HOME) },
                        icon = {
                            Icon(
                                if (currentTab == BottomTab.HOME) Icons.Filled.Home else Icons.Outlined.Home,
                                contentDescription = "Home"
                            )
                        },
                        label = { Text("Home") },
                        modifier = Modifier.testTag("nav_item_home")
                    )

                    NavigationBarItem(
                        selected = currentTab == BottomTab.COURSE,
                        onClick = { currentScreen = CurrentScreen.Tab(BottomTab.COURSE) },
                        icon = {
                            Icon(
                                if (currentTab == BottomTab.COURSE) Icons.Filled.MenuBook else Icons.Outlined.MenuBook,
                                contentDescription = "Course"
                            )
                        },
                        label = { Text("Course") },
                        modifier = Modifier.testTag("nav_item_course")
                    )

                    NavigationBarItem(
                        selected = currentTab == BottomTab.PRACTICE,
                        onClick = { currentScreen = CurrentScreen.Tab(BottomTab.PRACTICE) },
                        icon = {
                            Icon(
                                if (currentTab == BottomTab.PRACTICE) Icons.Filled.FitnessCenter else Icons.Outlined.FitnessCenter,
                                contentDescription = "Practice"
                            )
                        },
                        label = { Text("Practice") },
                        modifier = Modifier.testTag("nav_item_practice")
                    )

                    NavigationBarItem(
                        selected = currentTab == BottomTab.PLAYGROUND,
                        onClick = { currentScreen = CurrentScreen.Tab(BottomTab.PLAYGROUND) },
                        icon = {
                            Icon(
                                if (currentTab == BottomTab.PLAYGROUND) Icons.Filled.Code else Icons.Outlined.Code,
                                contentDescription = "Playground"
                            )
                        },
                        label = { Text("Playground") },
                        modifier = Modifier.testTag("nav_item_playground")
                    )

                    NavigationBarItem(
                        selected = currentTab == BottomTab.LIBRARY,
                        onClick = { currentScreen = CurrentScreen.Tab(BottomTab.LIBRARY) },
                        icon = {
                            Icon(
                                if (currentTab == BottomTab.LIBRARY) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                                contentDescription = "Library"
                            )
                        },
                        label = { Text("Library") },
                        modifier = Modifier.testTag("nav_item_library")
                    )

                    NavigationBarItem(
                        selected = currentTab == BottomTab.PROFILE,
                        onClick = { currentScreen = CurrentScreen.Tab(BottomTab.PROFILE) },
                        icon = {
                            Icon(
                                if (currentTab == BottomTab.PROFILE) Icons.Filled.Person else Icons.Outlined.Person,
                                contentDescription = "Profile"
                            )
                        },
                        label = { Text("Profile") },
                        modifier = Modifier.testTag("nav_item_profile")
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val screen = currentScreen) {
                is CurrentScreen.Tab -> {
                    when (screen.tab) {
                        BottomTab.HOME -> {
                            HomeScreen(
                                uiState = uiState,
                                onNavigateToCourse = { currentScreen = CurrentScreen.Tab(BottomTab.COURSE) },
                                onNavigateToModule = { navigateTo(CurrentScreen.ModuleDetail(it)) },
                                onNavigateToLesson = { navigateTo(CurrentScreen.LessonDetail(it)) },
                                onNavigateToPractice = { currentScreen = CurrentScreen.Tab(BottomTab.PRACTICE) },
                                onNavigateToPlayground = { currentScreen = CurrentScreen.Tab(BottomTab.PLAYGROUND) },
                                onNavigateToLibrary = { currentScreen = CurrentScreen.Tab(BottomTab.LIBRARY) },
                                onNavigateToSearch = { navigateTo(CurrentScreen.Search) },
                                onNavigateToProjects = { navigateTo(CurrentScreen.Projects) }
                            )
                        }
                        BottomTab.COURSE -> {
                            CourseScreen(
                                uiState = uiState,
                                onNavigateToModule = { navigateTo(CurrentScreen.ModuleDetail(it)) },
                                onNavigateToSearch = { navigateTo(CurrentScreen.Search) }
                            )
                        }
                        BottomTab.PRACTICE -> {
                            PracticeScreen(viewModel = viewModel)
                        }
                        BottomTab.PLAYGROUND -> {
                            PlaygroundScreen(viewModel = viewModel)
                        }
                        BottomTab.LIBRARY -> {
                            LibraryScreen(viewModel = viewModel)
                        }
                        BottomTab.PROFILE -> {
                            ProfileScreen(
                                viewModel = viewModel,
                                onNavigateToSettings = { navigateTo(CurrentScreen.Settings) },
                                onNavigateToCertificate = { navigateTo(CurrentScreen.Certificate) },
                                onNavigateToQuiz = { navigateTo(CurrentScreen.Quiz(it)) }
                            )
                        }
                    }
                }
                is CurrentScreen.ModuleDetail -> {
                    BackHandler { navigateBack() }
                    ModuleDetailScreen(
                        moduleId = screen.moduleId,
                        uiState = uiState,
                        onNavigateBack = { navigateBack() },
                        onNavigateToLesson = { navigateTo(CurrentScreen.LessonDetail(it)) },
                        onNavigateToQuiz = { navigateTo(CurrentScreen.Quiz(it)) }
                    )
                }
                is CurrentScreen.LessonDetail -> {
                    BackHandler { navigateBack() }
                    LessonDetailScreen(
                        lessonId = screen.lessonId,
                        viewModel = viewModel,
                        onNavigateBack = { navigateBack() },
                        onNavigateToLesson = { navigateTo(CurrentScreen.LessonDetail(it)) }
                    )
                }
                is CurrentScreen.Quiz -> {
                    BackHandler { navigateBack() }
                    QuizScreen(
                        quizId = screen.quizId,
                        viewModel = viewModel,
                        onNavigateBack = { navigateBack() }
                    )
                }
                is CurrentScreen.Projects -> {
                    BackHandler { navigateBack() }
                    ProjectsScreen(
                        viewModel = viewModel,
                        onNavigateBack = { navigateBack() },
                        onNavigateToPlayground = {
                            currentScreen = CurrentScreen.Tab(BottomTab.PLAYGROUND)
                            screenStack.clear()
                        }
                    )
                }
                is CurrentScreen.Certificate -> {
                    BackHandler { navigateBack() }
                    CertificateScreen(
                        viewModel = viewModel,
                        onNavigateBack = { navigateBack() },
                        onNavigateToQuiz = { navigateTo(CurrentScreen.Quiz(it)) }
                    )
                }
                is CurrentScreen.Settings -> {
                    BackHandler { navigateBack() }
                    SettingsScreen(
                        viewModel = viewModel,
                        onNavigateBack = { navigateBack() }
                    )
                }
                is CurrentScreen.Search -> {
                    BackHandler { navigateBack() }
                    SearchScreen(
                        viewModel = viewModel,
                        onNavigateBack = { navigateBack() },
                        onNavigateToLesson = { navigateTo(CurrentScreen.LessonDetail(it)) },
                        onNavigateToLibrary = {
                            currentScreen = CurrentScreen.Tab(BottomTab.LIBRARY)
                            screenStack.clear()
                        },
                        onNavigateToProjects = { navigateTo(CurrentScreen.Projects) }
                    )
                }
            }
        }
    }
}
