package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.content.QuizData
import com.example.data.model.Quiz
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.TertiaryAmberDark
import com.example.ui.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    quizId: String,
    viewModel: MainViewModel,
    onNavigateBack: () -> Unit
) {
    val quiz: Quiz? = QuizData.getQuiz(quizId)

    if (quiz == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Quiz not found")
        }
        return
    }

    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var isSubmitted by remember { mutableStateOf(false) }
    var score by remember { mutableIntStateOf(0) }
    var quizFinished by remember { mutableStateOf(false) }

    val currentQuestion = quiz.questions.getOrNull(currentQuestionIndex)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(quiz.title, maxLines = 1) },
                navigationIcon = {
                    IconButton(
                        onClick = onNavigateBack,
                        modifier = Modifier.testTag("quiz_back_button")
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        if (quizFinished) {
            val percentage = if (quiz.questions.isNotEmpty()) ((score.toFloat() / quiz.questions.size) * 100).toInt() else 0
            val passed = percentage >= quiz.passPercentage

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(20.dp)
                    .testTag("quiz_results_screen"),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(if (passed) SuccessGreen.copy(alpha = 0.2f) else ErrorRed.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (passed) Icons.Default.CheckCircle else Icons.Default.Close,
                            contentDescription = null,
                            tint = if (passed) SuccessGreen else ErrorRed,
                            modifier = Modifier.size(44.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = if (passed) "Assessment Passed! 🎉" else "Assessment Incomplete",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Score: $score / ${quiz.questions.size} ($percentage%)",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = if (passed) SuccessGreen else ErrorRed
                    )

                    Text(
                        text = if (passed) "Great job! Your progress has been updated."
                        else "Review the module lessons and retry to reach the ${quiz.passPercentage}% benchmark.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            currentQuestionIndex = 0
                            selectedOptionIndex = null
                            isSubmitted = false
                            score = 0
                            quizFinished = false
                        },
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth().height(50.dp).testTag("retry_quiz_button")
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Retry Assessment")
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedButton(
                        onClick = onNavigateBack,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth().height(50.dp)
                    ) {
                        Text("Return to Course")
                    }
                }
            }
        } else if (currentQuestion != null) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .testTag("quiz_question_view"),
                contentPadding = PaddingValues(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Column {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Question ${currentQuestionIndex + 1} of ${quiz.questions.size}",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Pass: ${quiz.passPercentage}%",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        LinearProgressIndicator(
                            progress = { ((currentQuestionIndex + 1).toFloat() / quiz.questions.size) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = MaterialTheme.colorScheme.primary
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = currentQuestion.question,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 28.sp
                        )
                    }
                }

                // Options
                items(currentQuestion.options.size) { optIdx ->
                    val optionText = currentQuestion.options[optIdx]
                    val isSelected = selectedOptionIndex == optIdx
                    val isCorrect = optIdx == currentQuestion.correctIndex

                    val containerColor = when {
                        !isSubmitted && isSelected -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)
                        isSubmitted && isCorrect -> SuccessGreen.copy(alpha = 0.2f)
                        isSubmitted && isSelected && !isCorrect -> ErrorRed.copy(alpha = 0.2f)
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    }

                    val borderColor = when {
                        !isSubmitted && isSelected -> MaterialTheme.colorScheme.primary
                        isSubmitted && isCorrect -> SuccessGreen
                        isSubmitted && isSelected && !isCorrect -> ErrorRed
                        else -> MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                    }

                    Card(
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = containerColor),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.5.dp, borderColor, RoundedCornerShape(14.dp))
                            .clickable(enabled = !isSubmitted) {
                                selectedOptionIndex = optIdx
                            }
                            .testTag("quiz_option_$optIdx")
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(borderColor.copy(alpha = 0.3f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = ('A'.code + optIdx).toChar().toString(),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp
                                )
                            }
                            Spacer(modifier = Modifier.width(14.dp))
                            Text(
                                text = optionText,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                            )
                        }
                    }
                }

                // Explanation
                if (isSubmitted) {
                    item {
                        Card(
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = if (selectedOptionIndex == currentQuestion.correctIndex) "Correct! ✓" else "Explanation:",
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = if (selectedOptionIndex == currentQuestion.correctIndex) SuccessGreen else MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = currentQuestion.explanation,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }

                // Action Controls
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                    if (!isSubmitted) {
                        Button(
                            onClick = {
                                if (selectedOptionIndex != null) {
                                    isSubmitted = true
                                    if (selectedOptionIndex == currentQuestion.correctIndex) {
                                        score++
                                    }
                                }
                            },
                            enabled = selectedOptionIndex != null,
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("submit_answer_button")
                        ) {
                            Text("Submit Answer")
                        }
                    } else {
                        Button(
                            onClick = {
                                if (currentQuestionIndex < quiz.questions.size - 1) {
                                    currentQuestionIndex++
                                    selectedOptionIndex = null
                                    isSubmitted = false
                                } else {
                                    quizFinished = true
                                    viewModel.submitQuiz(quiz.id, score, quiz.questions.size)
                                }
                            },
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("next_question_button")
                        ) {
                            Text(if (currentQuestionIndex < quiz.questions.size - 1) "Next Question" else "View Results")
                        }
                    }
                }
            }
        }
    }
}
