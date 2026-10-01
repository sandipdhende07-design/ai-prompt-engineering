package com.example.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.content.PracticeData
import com.example.data.model.PromptHeuristicScore
import com.example.ui.components.CodeOrPromptBlock
import com.example.ui.components.HeuristicScoreGauge
import com.example.ui.theme.SuccessGreen
import com.example.ui.viewmodel.MainViewModel

@Composable
fun PracticeScreen(
    viewModel: MainViewModel
) {
    val context = LocalContext.current
    val challenges = PracticeData.challenges
    var selectedIndex by remember { mutableIntStateOf(0) }
    val currentChallenge = challenges[selectedIndex]

    var userPromptText by remember(selectedIndex) { mutableStateOf("") }
    var evaluationResult by remember(selectedIndex) { mutableStateOf<PromptHeuristicScore?>(null) }
    var showBenchmark by remember(selectedIndex) { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("practice_screen_lazy_column"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.FitnessCenter,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Practice Arena",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Text(
                    text = "Write real prompts, receive automated heuristic diagnostics, and level up.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Challenge Selector Tabs
        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                itemsIndexed(challenges) { idx, ch ->
                    FilterChip(
                        selected = idx == selectedIndex,
                        onClick = {
                            selectedIndex = idx
                            evaluationResult = null
                            showBenchmark = false
                        },
                        label = { Text("Challenge ${idx + 1}: ${ch.title}") },
                        modifier = Modifier.testTag("practice_tab_$idx")
                    )
                }
            }
        }

        // Challenge Scenario Card
        item {
            Card(
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = currentChallenge.category,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = SuccessGreen.copy(alpha = 0.15f)
                        ) {
                            Text(
                                text = currentChallenge.difficulty,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = SuccessGreen,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = currentChallenge.task,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = currentChallenge.scenario,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Evaluation Criteria:",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                    currentChallenge.criteria.forEach { c ->
                        Text(
                            text = "✓ $c",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(start = 4.dp, top = 2.dp)
                        )
                    }
                }
            }
        }

        // Input Editor
        item {
            Column {
                Text(
                    text = "Your Engineered Prompt:",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    value = userPromptText,
                    onValueChange = { userPromptText = it },
                    placeholder = { Text("Write your prompt here using Role + Task + Context + Constraints...") },
                    minLines = 5,
                    maxLines = 10,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("practice_prompt_input")
                )
                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            if (userPromptText.isBlank()) {
                                Toast.makeText(context, "Please enter your prompt first", Toast.LENGTH_SHORT).show()
                            } else {
                                val eval = viewModel.analyzePrompt(prompt = userPromptText)
                                evaluationResult = eval
                                viewModel.submitPractice(currentChallenge.id, userPromptText, eval.overallScore)
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                            .testTag("evaluate_practice_button")
                    ) {
                        Text("Evaluate Prompt")
                    }

                    OutlinedButton(
                        onClick = { showBenchmark = !showBenchmark },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.height(48.dp)
                    ) {
                        Text(if (showBenchmark) "Hide Solution" else "View Solution")
                    }
                }
            }
        }

        // Heuristic Diagnostic Feedback
        if (evaluationResult != null) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    HeuristicScoreGauge(score = evaluationResult!!)

                    CodeOrPromptBlock(
                        text = evaluationResult!!.suggestedRevision,
                        title = "Suggested Revision Formula"
                    )
                }
            }
        }

        // Benchmark Solution
        if (showBenchmark) {
            item {
                CodeOrPromptBlock(
                    text = currentChallenge.sampleGoodPrompt,
                    title = "Gold Standard Benchmark Solution"
                )
            }
        }
    }
}
