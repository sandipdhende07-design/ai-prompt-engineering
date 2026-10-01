package com.example.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.data.model.PromptHeuristicScore
import com.example.ui.components.CodeOrPromptBlock
import com.example.ui.components.HeuristicScoreGauge
import com.example.ui.viewmodel.MainViewModel

@Composable
fun PlaygroundScreen(
    viewModel: MainViewModel
) {
    val context = LocalContext.current

    var isStructuredMode by remember { mutableStateOf(false) }

    // Freeform prompt
    var freeformPrompt by remember { mutableStateOf("") }

    // Structured fields
    var roleField by remember { mutableStateOf("") }
    var goalField by remember { mutableStateOf("") }
    var contextField by remember { mutableStateOf("") }
    var constraintsField by remember { mutableStateOf("") }
    var formatField by remember { mutableStateOf("") }
    var examplesField by remember { mutableStateOf("") }

    // Analysis Result
    var analysisResult by remember { mutableStateOf<PromptHeuristicScore?>(null) }
    var assembledPrompt by remember { mutableStateOf("") }

    // Save Dialog State
    var showSaveDialog by remember { mutableStateOf(false) }
    var promptTitleToSave by remember { mutableStateOf("") }
    var promptCategoryToSave by remember { mutableStateOf("Productivity") }

    fun buildFullPromptText(): String {
        return if (isStructuredMode) {
            buildString {
                if (roleField.isNotBlank()) append("Role: $roleField\n")
                if (goalField.isNotBlank()) append("Task: $goalField\n")
                if (contextField.isNotBlank()) append("Context: $contextField\n")
                if (constraintsField.isNotBlank()) append("Constraints: $constraintsField\n")
                if (formatField.isNotBlank()) append("Output Format: $formatField\n")
                if (examplesField.isNotBlank()) append("Examples: $examplesField\n")
            }.trim()
        } else {
            freeformPrompt.trim()
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("playground_screen_lazy_column"),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Top Header
        item {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Code,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Prompt Playground",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    // Mode switch
                    Row {
                        FilterChip(
                            selected = !isStructuredMode,
                            onClick = { isStructuredMode = false },
                            label = { Text("Freeform") }
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        FilterChip(
                            selected = isStructuredMode,
                            onClick = { isStructuredMode = true },
                            label = { Text("Structured") },
                            modifier = Modifier.testTag("playground_structured_tab")
                        )
                    }
                }
                Text(
                    text = "Craft, analyze, optimize, and save custom prompt architectures.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Input Area
        item {
            if (!isStructuredMode) {
                Column {
                    Text(
                        text = "Write your prompt here:",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    OutlinedTextField(
                        value = freeformPrompt,
                        onValueChange = {
                            freeformPrompt = it
                            assembledPrompt = it
                        },
                        placeholder = { Text("Write your prompt here… e.g. You are an expert Android engineer...") },
                        minLines = 6,
                        maxLines = 14,
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("playground_freeform_input")
                    )
                }
            } else {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Prompt Architecture Fields",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        OutlinedTextField(
                            value = roleField,
                            onValueChange = { roleField = it },
                            label = { Text("Role (Who)") },
                            placeholder = { Text("e.g., Senior Software Architect") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth().testTag("field_role")
                        )

                        OutlinedTextField(
                            value = goalField,
                            onValueChange = { goalField = it },
                            label = { Text("Goal / Task (What)") },
                            placeholder = { Text("e.g., Refactor this Composable function") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth().testTag("field_goal")
                        )

                        OutlinedTextField(
                            value = contextField,
                            onValueChange = { contextField = it },
                            label = { Text("Context (Why/Where)") },
                            placeholder = { Text("e.g., Target Android 15, low-memory device") },
                            minLines = 2,
                            modifier = Modifier.fillMaxWidth().testTag("field_context")
                        )

                        OutlinedTextField(
                            value = constraintsField,
                            onValueChange = { constraintsField = it },
                            label = { Text("Constraints (Boundaries)") },
                            placeholder = { Text("e.g., Under 150 words, no third-party libs") },
                            minLines = 2,
                            modifier = Modifier.fillMaxWidth().testTag("field_constraints")
                        )

                        OutlinedTextField(
                            value = formatField,
                            onValueChange = { formatField = it },
                            label = { Text("Output Format (Structure)") },
                            placeholder = { Text("e.g., Markdown table with 3 columns") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth().testTag("field_format")
                        )

                        OutlinedTextField(
                            value = examplesField,
                            onValueChange = { examplesField = it },
                            label = { Text("Examples (Few-Shot)") },
                            placeholder = { Text("Input: ... Output: ...") },
                            minLines = 2,
                            modifier = Modifier.fillMaxWidth().testTag("field_examples")
                        )
                    }
                }
            }
        }

        // Action Buttons Row (Generate, Improve, Analyze, Save, Clear)
        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            val prompt = buildFullPromptText()
                            if (prompt.isBlank()) {
                                Toast.makeText(context, "Enter a prompt first", Toast.LENGTH_SHORT).show()
                            } else {
                                assembledPrompt = prompt
                                analysisResult = viewModel.analyzePrompt(
                                    prompt = if (isStructuredMode) goalField else freeformPrompt,
                                    role = roleField,
                                    context = contextField,
                                    constraints = constraintsField,
                                    outputFormat = formatField,
                                    examples = examplesField
                                )
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f).height(48.dp).testTag("analyze_prompt_button")
                    ) {
                        Icon(Icons.Default.Tune, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Analyze Prompt")
                    }

                    OutlinedButton(
                        onClick = {
                            val prompt = buildFullPromptText()
                            if (prompt.isBlank()) {
                                Toast.makeText(context, "Enter a prompt first", Toast.LENGTH_SHORT).show()
                            } else {
                                val eval = viewModel.analyzePrompt(
                                    prompt = if (isStructuredMode) goalField else freeformPrompt,
                                    role = roleField,
                                    context = contextField,
                                    constraints = constraintsField,
                                    outputFormat = formatField,
                                    examples = examplesField
                                )
                                analysisResult = eval
                                assembledPrompt = eval.suggestedRevision
                                if (!isStructuredMode) {
                                    freeformPrompt = eval.suggestedRevision
                                }
                                Toast.makeText(context, "Optimized revision generated!", Toast.LENGTH_SHORT).show()
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f).height(48.dp).testTag("improve_prompt_button")
                    ) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Improve")
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedButton(
                        onClick = {
                            val prompt = buildFullPromptText()
                            if (prompt.isBlank()) {
                                Toast.makeText(context, "Nothing to save yet", Toast.LENGTH_SHORT).show()
                            } else {
                                assembledPrompt = prompt
                                promptTitleToSave = if (goalField.isNotBlank()) goalField else "Custom Prompt"
                                showSaveDialog = true
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f).height(46.dp).testTag("save_prompt_button")
                    ) {
                        Icon(Icons.Default.Bookmark, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Save Prompt")
                    }

                    OutlinedButton(
                        onClick = {
                            freeformPrompt = ""
                            roleField = ""
                            goalField = ""
                            contextField = ""
                            constraintsField = ""
                            formatField = ""
                            examplesField = ""
                            analysisResult = null
                            assembledPrompt = ""
                        },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.height(46.dp).testTag("clear_playground_button")
                    ) {
                        Icon(Icons.Default.Clear, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Clear")
                    }
                }
            }
        }

        // Assembled / Generated Prompt Preview
        if (assembledPrompt.isNotBlank()) {
            item {
                CodeOrPromptBlock(
                    text = assembledPrompt,
                    title = "Generated Prompt Output"
                )
            }
        }

        // Heuristic Analysis Results
        if (analysisResult != null) {
            item {
                HeuristicScoreGauge(score = analysisResult!!)
            }
        }
    }

    // Save Prompt Dialog
    if (showSaveDialog) {
        AlertDialog(
            onDismissRequest = { showSaveDialog = false },
            title = { Text("Save Prompt to Library") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedTextField(
                        value = promptTitleToSave,
                        onValueChange = { promptTitleToSave = it },
                        label = { Text("Title") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = promptCategoryToSave,
                        onValueChange = { promptCategoryToSave = it },
                        label = { Text("Category (e.g., Coding, Education)") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        viewModel.savePrompt(
                            title = promptTitleToSave.ifBlank { "Custom Prompt" },
                            category = promptCategoryToSave.ifBlank { "Custom" },
                            promptText = assembledPrompt
                        )
                        showSaveDialog = false
                        Toast.makeText(context, "Prompt saved to Library!", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(onClick = { showSaveDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}
