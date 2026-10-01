package com.example.data.evaluator

import com.example.data.model.PromptHeuristicScore

object PromptEvaluator {

    /**
     * Evaluates a prompt against prompt engineering best practices.
     * Note: This is an educational heuristic score to guide learning,
     * not an absolute or mathematical measure of LLM performance.
     */
    fun evaluatePrompt(
        prompt: String,
        role: String = "",
        context: String = "",
        constraints: String = "",
        outputFormat: String = "",
        examples: String = ""
    ): PromptHeuristicScore {
        val fullText = buildString {
            if (role.isNotBlank()) append("Role: $role\n")
            append(prompt)
            if (context.isNotBlank()) append("\nContext: $context")
            if (constraints.isNotBlank()) append("\nConstraints: $constraints")
            if (outputFormat.isNotBlank()) append("\nFormat: $outputFormat")
            if (examples.isNotBlank()) append("\nExamples: $examples")
        }.trim()

        if (fullText.isBlank()) {
            return PromptHeuristicScore(
                clarityScore = 0,
                contextScore = 0,
                specificityScore = 0,
                constraintsScore = 0,
                outputFormatScore = 0,
                overallScore = 0,
                strengths = emptyList(),
                suggestions = listOf("Start by writing your main instruction or task."),
                suggestedRevision = "You are a [Role]. Your task is to [Specific Action] based on [Context]. Constraints: [Rules]. Output format: [Format]."
            )
        }

        val lower = fullText.lowercase()
        val strengths = mutableListOf<String>()
        val suggestions = mutableListOf<String>()

        // 1. Clarity Assessment
        var clarity = 50
        val actionVerbs = listOf(
            "explain", "write", "generate", "analyze", "create", "summarize",
            "compare", "critique", "refactor", "diagnose", "list", "draft", "calculate"
        )
        val hasActionVerb = actionVerbs.any { lower.contains(it) }
        if (hasActionVerb) {
            clarity += 30
            strengths.add("Includes a clear primary action verb")
        } else {
            suggestions.add("Begin with an imperative action verb (e.g., 'Analyze', 'Generate', 'Explain').")
        }

        val vagueWords = listOf("stuff", "things", "everything", "anything", "good job", "info")
        if (vagueWords.any { lower.contains(it) }) {
            clarity -= 20
            suggestions.add("Replace ambiguous words like 'stuff' or 'things' with concrete terminology.")
        } else {
            clarity += 20
        }
        clarity = clarity.coerceIn(10, 100)

        // 2. Context Assessment
        var contextScore = 30
        val contextKeywords = listOf(
            "context:", "background", "audience", "for beginners", "student", "developer",
            "scenario", "situation", "purpose", "aim", "because", "target audience"
        )
        val hasContextKey = contextKeywords.any { lower.contains(it) } || context.isNotBlank()
        if (hasContextKey) {
            contextScore += 45
            strengths.add("Provides relevant background or audience context")
        } else {
            suggestions.add("Add context regarding the target audience, domain background, or current scenario.")
        }
        if (fullText.length > 80) {
            contextScore += 25
        }
        contextScore = contextScore.coerceIn(10, 100)

        // 3. Specificity Assessment
        var specificity = 35
        val roleIndicators = listOf("you are", "act as", "role:", "as a professional", "expert")
        val hasRole = roleIndicators.any { lower.contains(it) } || role.isNotBlank()
        if (hasRole) {
            specificity += 35
            strengths.add("Assigns a distinct expert persona or role")
        } else {
            suggestions.add("Adopt an expert persona (e.g., 'Act as a Senior Android Architect').")
        }

        val specificDetails = listOf("step-by-step", "detailed", "concise", "in hindi", "in python", "android", "level")
        if (specificDetails.any { lower.contains(it) }) {
            specificity += 30
            strengths.add("Specifies domain or execution depth details")
        }
        specificity = specificity.coerceIn(15, 100)

        // 4. Constraints Assessment
        var constraintsScore = 20
        val constraintWords = listOf(
            "do not", "avoid", "must not", "limit to", "within", "max", "maximum",
            "words", "under 100", "only return", "strictly", "no preamble", "negative prompt"
        )
        val hasConstraints = constraintWords.any { lower.contains(it) } || constraints.isNotBlank()
        if (hasConstraints) {
            constraintsScore += 70
            strengths.add("Sets clear boundary constraints or negative rules")
        } else {
            suggestions.add("Add boundaries: e.g., 'Limit response to 200 words' or 'Do not include introductory commentary'.")
        }
        constraintsScore = constraintsScore.coerceIn(10, 100)

        // 5. Output Format Assessment
        var formatScore = 20
        val formatWords = listOf(
            "json", "markdown", "bullet", "bullets", "table", "numbered list",
            "csv", "xml", "step 1", "format as", "heading", "schema"
        )
        val hasFormat = formatWords.any { lower.contains(it) } || outputFormat.isNotBlank()
        if (hasFormat) {
            formatScore += 75
            strengths.add("Explicitly defines expected output format (table, JSON, or list)")
        } else {
            suggestions.add("Define an explicit structure: e.g., 'Return as Markdown bullet points' or 'Output valid JSON'.")
        }
        formatScore = formatScore.coerceIn(10, 100)

        val overall = ((clarity * 0.25) + (contextScore * 0.20) + (specificity * 0.20) + (constraintsScore * 0.15) + (formatScore * 0.20)).toInt()

        // Generate an intelligent suggested revision
        val suggestedRevision = buildString {
            val roleToUse = if (role.isNotBlank()) role else "an expert instructor"
            append("### Role\nYou are $roleToUse.\n\n")
            append("### Task\n")
            if (prompt.isNotBlank()) {
                append(prompt.trim())
            } else {
                append("Explain the core concept in clear, accessible terms.")
            }
            append("\n\n")
            append("### Context\n")
            if (context.isNotBlank()) {
                append(context.trim())
            } else {
                append("Target audience has fundamental computer literacy but is new to generative AI.")
            }
            append("\n\n")
            append("### Constraints\n")
            if (constraints.isNotBlank()) {
                append(constraints.trim())
            } else {
                append("- Keep response under 250 words.\n- Avoid overly technical jargon without a 1-sentence analogy.\n- Do not include conversational greetings.")
            }
            append("\n\n")
            append("### Output Format\n")
            if (outputFormat.isNotBlank()) {
                append(outputFormat.trim())
            } else {
                append("1. Core Definition (1 sentence)\n2. Everyday Analogy\n3. 3 Practical Bullet Points\n4. Common Pitfall to Avoid")
            }
        }

        return PromptHeuristicScore(
            clarityScore = clarity,
            contextScore = contextScore,
            specificityScore = specificity,
            constraintsScore = constraintsScore,
            outputFormatScore = formatScore,
            overallScore = overall,
            strengths = strengths.ifEmpty { listOf("Prompt contains text to build upon") },
            suggestions = suggestions.ifEmpty { listOf("Excellent prompt structure following standard frameworks.") },
            suggestedRevision = suggestedRevision
        )
    }
}
