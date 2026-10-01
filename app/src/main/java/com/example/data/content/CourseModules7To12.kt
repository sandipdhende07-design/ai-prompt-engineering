package com.example.data.content

import com.example.data.model.CourseModule
import com.example.data.model.Lesson

object CourseModules7To12 {

    val module7 = CourseModule(
        id = "mod_7",
        number = 7,
        title = "Output Control & Formatting",
        subtitle = "Tables, JSON, Tone, and Structured Schemas",
        description = "Command the exact structure, tone, audience level, and schema of every model generation for reliable human reading and programmatic integration.",
        iconName = "FormatListBulleted",
        quizId = "quiz_7",
        lessons = listOf(
            Lesson(
                id = "m7_l1",
                moduleId = "mod_7",
                number = 1,
                title = "Controlling Structure: Bullets, Tables & Markdown",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Format outputs for high scannability using Markdown",
                    "Construct comparative tables with explicit column headers",
                    "Design hierarchical numbered procedures"
                ),
                explanation = """
Human eyes scan text in an 'F-shape' pattern. Walls of unformatted text are rarely read.

By dictating formatting, you turn raw model thoughts into clean, professional deliverables.

**Key Formatting Tools:**
1. **Markdown Tables:** Perfect for tradeoffs, pricing comparisons, and feature matrices.
   *Prompt:* `Format as a table with columns: [Feature | Competitor A | Competitor B | Winner]`
2. **Bolded Bullet Points:** Each bullet starts with a 2-word bold anchor.
   *Prompt:* `Format as 5 bullet points. Start each bullet with a bolded 2-word summary followed by a colon.`
3. **Numbered Steps with Sub-bullets:** For linear workflows.
   *Prompt:* `Number the main steps (1, 2, 3), and use indented hyphens for the underlying rationale.`
                """.trimIndent(),
                badPrompt = "Compare React and Flutter.",
                improvedPrompt = """
Compare React Native and Flutter for mobile app development.
Format your response as a Markdown table with exactly 5 rows and these columns:
| Dimension | React Native | Flutter | Advantage / Recommendation |
Include dimensions: Language, Performance, Community Ecosystem, Native UI Fidelity, Learning Curve.
                """.trimIndent(),
                whyImproved = "Defines the exact dimensions, columns, and tabular layout.",
                keyPoints = listOf(
                    "Explicitly name every column header when requesting tables.",
                    "Use bold anchors at the start of bullet points to dramatically improve readability.",
                    "Tables force the model to provide parallel, structured analysis."
                ),
                miniExercise = "Write a prompt requesting a comparison of 3 cloud database options formatted as a 4-column Markdown table.",
                miniExerciseHint = "Columns: Database Name, Type (SQL/NoSQL), Pricing Model, Best Use Case."
            ),
            Lesson(
                id = "m7_l2",
                moduleId = "mod_7",
                number = 2,
                title = "Tone, Voice & Audience Calibration",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Calibrate tone across formal, witty, academic, empathetic, and urgent",
                    "Calibrate cognitive audience levels (ELI5 vs C-suite vs Domain Specialist)",
                    "Maintain consistent brand voice across generated assets"
                ),
                explanation = """
A generation that is technically accurate but written for the wrong audience is a failed prompt.

**Audience Levels:**
- **ELI5 (Explain Like I'm 5):** Concrete everyday metaphors, simple vocabulary, short sentences, zero technical jargon.
- **Undergraduate / General Public:** Clear explanations, standard industry terms explained upon first mention.
- **C-Suite / Executive:** High-level strategic impacts, bottom-line ROI, risk mitigation, zero granular operational minutiae.
- **Domain Specialist:** Dense technical terminology, formal methodology, exact statistical metrics.

**Tone Descriptors:**
Avoid generic words like *"make it nice"*. Use evocative, precise adjectives:
`Empathetic yet authoritative`, `Urgent, crisp, and direct`, `Playful and irreverent`, `Scholarly and measured`.
                """.trimIndent(),
                badPrompt = "Explain inflation simply.",
                improvedPrompt = "Explain inflation to a 10-year-old child who receives $10 a week in pocket money. Use the analogy of buying their favorite candy bars over time. Limit to 3 short paragraphs.",
                whyImproved = "Tailors the reader persona (10-year-old child) and grounds the explanation in an immediate, relatable metaphor (candy bars).",
                keyPoints = listOf(
                    "Always define the target reader's age, background, and familiarity with the topic.",
                    "Use precise tone adjectives instead of vague words like 'good' or 'nice'.",
                    "Tailor metaphors to the reader's daily experience."
                ),
                miniExercise = "Rewrite a prompt explaining 'Quantum Computing' first for a 12-year-old, and second for a venture capital tech investor.",
                miniExerciseHint = "12-year-old: coin spinning analogy; VC investor: market disruption and cryptography implications."
            )
        )
    )

    val module8 = CourseModule(
        id = "mod_8",
        number = 8,
        title = "Prompt Debugging",
        subtitle = "Diagnosing and Fixing Broken Prompts",
        description = "Learn the systematic diagnostic method to uncover why prompts fail: ambiguous instructions, missing context, instruction conflict, and format leakage.",
        iconName = "BugReport",
        quizId = "quiz_8",
        lessons = listOf(
            Lesson(
                id = "m8_l1",
                moduleId = "mod_8",
                number = 1,
                title = "The 7 Deadly Sins of Prompting",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Diagnose the 7 most common failure modes in user prompts",
                    "Identify ambiguous instructions and missing context",
                    "Resolve conflicting and contradictory constraints"
                ),
                explanation = """
When an AI generates poor output, 95% of the time the flaw is in the prompt, not the model.

**The 7 Deadly Sins:**
1. **Ambiguity:** *"Give me insights on sales."* (What kind of insights? What timeframe? What product?)
2. **Missing Context:** Asking for advice without mentioning the user's constraints, tech stack, or budget.
3. **Contradictory Instructions:** *"Write a comprehensive, exhaustive guide under 100 words."* (You cannot be both exhaustive and under 100 words).
4. **Instruction Overload:** Stacking 25 micro-rules in a single prompt until the model suffers cognitive interference.
5. **No Output Specification:** Letting the model guess whether you want an essay, bullets, or code.
6. **Unstated Audience:** Letting the model default to an arbitrary reading level.
7. **Negative Priming:** Repeating forbidden phrases so many times the model fixates on them.
                """.trimIndent(),
                badPrompt = "Write an exhaustive, complete guide to learning Android development in 150 words.",
                improvedPrompt = """
Create a beginner roadmap for learning Android development with Kotlin and Jetpack Compose.
Focus exclusively on the 4 essential milestones:
1. Kotlin syntax fundamentals
2. Jetpack Compose UI basics
3. State management & ViewModel
4. Room database persistence
Provide a 2-sentence summary and 1 recommended practice project per milestone.
                """.trimIndent(),
                whyImproved = "Eliminates the contradiction between 'exhaustive' and '150 words' by framing it as a 4-milestone roadmap with strict structure.",
                keyPoints = listOf(
                    "Identify and eliminate contradictory constraints.",
                    "Narrow broad requests into specific, numbered components.",
                    "If a prompt fails, inspect the 7 deadly sins before blaming the model."
                ),
                miniExercise = "Identify the flaw in: 'Write a long, detailed technical report that is quick and easy to read on a mobile phone.'",
                miniExerciseHint = "Contradiction: 'Long and detailed' conflicts with 'quick to read on a mobile phone'."
            ),
            Lesson(
                id = "m8_l2",
                moduleId = "mod_8",
                number = 2,
                title = "The Diagnosis & Repair Protocol",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Apply the 3-step Diagnostic Protocol: Isolate, Diagnose, Refactor",
                    "Inspect model outputs for specific failure symptoms",
                    "Iterate systematically until deterministic accuracy is achieved"
                ),
                explanation = """
When debugging an enterprise prompt, follow the **Diagnostic Protocol**:

**Step 1: Isolate the Symptom**
- Is the output too verbose? (Symptom: Missing length constraint).
- Did it hallucinate facts? (Symptom: Missing grounding context and escape hatch).
- Is it conversational when you needed code? (Symptom: Missing output formatting command).
- Did it ignore rule #4? (Symptom: Attentional overload or rule buried in the middle).

**Step 2: Diagnose the Root Cause**
Review where the instruction was placed, whether it conflicted with other directives, and whether formatting was explicitly demonstrated.

**Step 3: Refactor & Retest**
Make ONE modification at a time so you know exactly which change solved the issue.
                """.trimIndent(),
                badPrompt = "Extract names and dates from this email: [Email text]",
                improvedPrompt = """
Extract all person names and dates mentioned in the email below.
Output format:
- Name: [Full Name] | Date Mentioned: [Date] | Associated Action: [Action]
If no date is associated with a person, write 'None'.
Email:
[Email text]
                """.trimIndent(),
                whyImproved = "Fixes format ambiguity and specifies how to handle missing dates (edge case).",
                keyPoints = listOf(
                    "Diagnose the specific symptom before rewriting the entire prompt.",
                    "Specify fallback values for missing edge-case data.",
                    "Change one variable at a time when optimizing."
                ),
                miniExercise = "A prompt returned JSON wrapped in conversational pleasantries. What single line should you append to fix it?",
                miniExerciseHint = "'Return ONLY the raw JSON object. Do not include markdown tags, preamble, or commentary.'"
            )
        )
    )

    val module9 = CourseModule(
        id = "mod_9",
        number = 9,
        title = "Prompt Optimization & Iteration",
        subtitle = "The 10-Step Professional Workflow",
        description = "Master the continuous refinement lifecycle: baseline drafting, empirical testing, error analysis, constraint tightening, and prompt versioning.",
        iconName = "Tune",
        quizId = "quiz_9",
        lessons = listOf(
            Lesson(
                id = "m9_l1",
                moduleId = "mod_9",
                number = 1,
                title = "The 10-Step Optimization Lifecycle",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Execute the 10-step prompt engineering lifecycle",
                    "Conduct side-by-side comparative A/B testing of prompts",
                    "Maintain prompt versioning in software repositories"
                ),
                explanation = """
Prompt engineering is an empirical science. Professional prompt engineers never ship their first draft.

**The 10-Step Optimization Lifecycle:**
1. **Draft Initial Prompt:** Write baseline instructions stating task and objective.
2. **Execute Baseline Test:** Run with 3-5 representative inputs.
3. **Identify Weaknesses:** Flag hallucinations, awkward phrasing, or layout bugs.
4. **Add Context:** Inject missing definitions, audience info, or background facts.
5. **Enforce Persona:** Add role specification for vocabulary and authority.
6. **Add Constraints:** Block unwanted phrases, establish length limits, and negative rules.
7. **Add Few-Shot Examples:** Provide 1-2 pristine input/output exemplars.
8. **Re-test Against Edge Cases:** Test with empty inputs, adversarial text, or extreme lengths.
9. **Side-by-Side Comparison:** Compare v1 baseline vs v2 optimized outputs.
10. **Version & Commit:** Save the prompt template with clear documentation.
                """.trimIndent(),
                badPrompt = "Give me ideas for social media posts.",
                improvedPrompt = """
Role: Senior B2B Social Media Strategist.
Task: Generate 5 LinkedIn post concepts for an AI cybersecurity software launch.
Target Audience: Chief Information Security Officers (CISOs).
Framework per concept:
- The Hook: Scroll-stopping 1-sentence contrarian observation.
- The Core Value: 3 bullet points with a practical security takeaway.
- The Engagement Question: Question prompting comments.
Constraints: No emojis; no hashtags; professional, authoritative tone.
                """.trimIndent(),
                whyImproved = "Evolved through the 10-step lifecycle: persona added, target defined, framework enforced, constraints applied.",
                keyPoints = listOf(
                    "Never settle for the first response; iterate systematically.",
                    "Test prompts against realistic diverse inputs, not just ideal cases.",
                    "Save prompt revisions like code commits."
                ),
                miniExercise = "Take a prompt you wrote recently and apply Steps 4, 5, and 6 to produce an optimized v2.",
                miniExerciseHint = "Add rich context, a specialized persona, and 3 explicit constraints."
            )
        )
    )

    val module10 = CourseModule(
        id = "mod_10",
        number = 10,
        title = "AI for Students & Learning",
        subtitle = "Smarter Studying, Flashcards, and Verification",
        description = "Harness Generative AI as an infinitely patient personal tutor: Socratic dialogues, Feynman technique explanations, active recall flashcards, and critical fact verification.",
        iconName = "School",
        quizId = "quiz_10",
        lessons = listOf(
            Lesson(
                id = "m10_l1",
                moduleId = "mod_10",
                number = 1,
                title = "The Feynman Technique & Socratic Tutoring",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Use the Feynman Technique to master complex subjects",
                    "Prompt AI for Socratic interactive study sessions",
                    "Avoid cognitive outsourcing and passive reading"
                ),
                explanation = """
Using AI for studying is not about having an algorithm write your homework. That produces cognitive atrophy.

True mastery comes from using AI as a **high-engagement thinking partner**.

**1. The Feynman Technique Prompt:**
Richard Feynman famously taught that if you cannot explain a concept to a child in simple terms, you do not truly understand it.
*Prompt Formula:*
*"I am going to explain [Topic] to you as if you were 12 years old. Critique my explanation: point out where I used jargon without explaining it, where my logic skipped a step, and what vital intuition I missed."*

**2. The Socratic Tutor Prompt:**
*"You are my Socratic tutor for Organic Chemistry. Do not give me direct answers. Ask me one question at a time to guide me to the reaction mechanism. If I make an error, challenge my assumption with an example."*
                """.trimIndent(),
                badPrompt = "Explain calculus.",
                improvedPrompt = """
You are a patient mathematics mentor.
I am studying derivatives in calculus.
Teach me the concept of the derivative using the analogy of a car speedometer vs total odometer distance.
Follow this format:
1. Everyday Analogy (100 words)
2. Mathematical Intuition (how limits work without heavy notation)
3. A quick check-for-understanding question for me to answer.
                """.trimIndent(),
                whyImproved = "Uses a concrete physical analogy and includes an active recall question.",
                keyPoints = listOf(
                    "Use AI to critique your own explanations rather than passively reading summaries.",
                    "Socratic prompting keeps you actively engaged turn-by-turn.",
                    "Analogies bridge abstract theory to intuitive understanding."
                ),
                miniExercise = "Write a prompt asking AI to quiz you on photosynthesis with 3 progressive difficulty questions, evaluating your answer after each.",
                miniExerciseHint = "Instruct the model to wait for your answer before providing the next question."
            ),
            Lesson(
                id = "m10_l2",
                moduleId = "mod_10",
                number = 2,
                title = "Active Recall, Flashcards & Critical Verification",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Generate spaced-repetition Anki-style flashcards in CSV/table format",
                    "Create scenario-based practice exam questions",
                    "Practice rigorous fact-verification and cross-referencing"
                ),
                explanation = """
Cognitive science demonstrates that **Active Recall** and **Spaced Repetition** are the most effective study methods known.

**Generating Anki Flashcards:**
```
Convert the lecture notes below into 10 high-yield Anki flashcards.
Format: 2-column Markdown table: | Front (Question/Prompt) | Back (Concise Answer) |
Rules:
- Front should test a single atomic concept.
- Back must be under 30 words.
- Avoid True/False; use 'Why' or 'How' questions.
```

**Critical Rule of Academic Integrity:**
Never submit AI-generated text as your own research. Always verify citations against original academic databases (Google Scholar, PubMed) because LLMs regularly fabricate plausible-sounding academic papers.
                """.trimIndent(),
                badPrompt = "Make flashcards for biology.",
                improvedPrompt = """
Generate 8 atomic active-recall flashcards from the text on cellular respiration below.
Columns: | Front (Question) | Back (Answer) |
Ensure each card tests exactly one mechanism (e.g., ATP yield of glycolysis, role of NAD+).
                """.trimIndent(),
                whyImproved = "Specifies atomic card design, exact column schema, and targeted sub-mechanisms.",
                keyPoints = listOf(
                    "Atomic flashcards test one single concept per card.",
                    "Active recall strengthens neural pathways far better than passive re-reading.",
                    "Always independently verify all AI citations and factual claims."
                ),
                miniExercise = "Draft a prompt that generates 3 multiple-choice questions with tricky plausible distractors from a chapter of history notes.",
                miniExerciseHint = "Instruct the model to explain why the incorrect options are wrong."
            )
        )
    )

    val module11 = CourseModule(
        id = "mod_11",
        number = 11,
        title = "AI for Coding & Software Development",
        subtitle = "From Architecture to Bug Fixing and Android",
        description = "Turn AI into a 10x pairing partner: writing clean idiomatic code, diagnosing cryptic stacktraces, writing unit tests, and Kotlin/Compose best practices.",
        iconName = "Terminal",
        quizId = "quiz_11",
        lessons = listOf(
            Lesson(
                id = "m11_l1",
                moduleId = "mod_11",
                number = 1,
                title = "The Developer's Prompt Framework",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Master the 6-part developer prompt framework",
                    "Provide error stack traces, dependencies, and environment context",
                    "Enforce idiomatic conventions and modern language standards"
                ),
                explanation = """
Programming prompts require maximum precision. A vague coding prompt produces outdated, non-compiling, or insecure code.

**The 6-Part Developer Prompt Framework:**
1. **Language & Version:** `Kotlin 2.0`, `Jetpack Compose M3`, `Java 17`.
2. **Current State & Context:** Existing code, signatures, and imports.
3. **Problem / Goal:** What the code needs to accomplish or the bug observed.
4. **Error Trace (if debugging):** Exact stack trace, logs, and unexpected output.
5. **Constraints:** `Use coroutines Flow`, `No third-party libraries`, `Handle NullPointerException`.
6. **Expected Deliverable:** Full production-ready snippet with error handling and unit test.
                """.trimIndent(),
                badPrompt = "My Android app crashes when clicking button.",
                improvedPrompt = """
You are a senior Android developer.
Environment: Kotlin 2.0, Jetpack Compose, Room 2.7.
Problem: App crashes with `IllegalStateException: Cannot access database on the main thread` when saving a user note.

Current Composable:
```kotlin
Button(onClick = { db.noteDao().insert(Note(text = noteText)) }) {
    Text("Save Note")
}
```

Task:
1. Diagnose why this violates Android architecture guidelines.
2. Refactor into proper MVVM using `ViewModel`, `viewModelScope.launch`, and `Dispatchers.IO`.
3. Provide the clean ViewModel and Composable code.
                """.trimIndent(),
                whyImproved = "Supplies exact stack trace error, current code snippet, tech stack, and architectural goal (MVVM).",
                keyPoints = listOf(
                    "Always declare the exact language version and framework (e.g., Jetpack Compose M3).",
                    "Paste the exact stack trace and error logs.",
                    "Request architectural patterns (e.g., MVVM, Repository pattern) explicitly."
                ),
                miniExercise = "Write a developer prompt asking an AI to generate a Room DAO with Coroutines Flow for an offline caching database.",
                miniExerciseHint = "Mention `@Dao`, `Flow<List<Item>>`, `suspend fun insert`, and `@Query`."
            ),
            Lesson(
                id = "m11_l2",
                moduleId = "mod_11",
                number = 2,
                title = "Refactoring, Unit Tests & Code Documentation",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Prompt for clean code refactoring without altering runtime behavior",
                    "Generate comprehensive unit tests covering edge cases",
                    "Write clear KDoc and technical architecture documentation"
                ),
                explanation = """
AI is extraordinarily skilled at **refactoring** and **testing**, tasks that developers frequently postpone.

**1. Refactoring Prompt Formula:**
`Refactor this function to improve readability and time complexity. Constraints: Do not change the public method signature or external behavior. Eliminate nested loops and magic numbers. Keep code idiomatic.`

**2. Test Generation Formula:**
`Write JUnit 4 unit tests for this Kotlin repository class. Include:`
- Happy path test case
- Boundary/edge case (empty list, null values, 0 items)
- Error condition (network timeout exception)
- Mock external dependencies using standard patterns.

**3. Documentation Formula:**
`Write professional KDoc documentation for this class. Include parameter explanations, return values, exceptions thrown, and a minimal usage code snippet.`
                """.trimIndent(),
                badPrompt = "Write tests for this code.",
                improvedPrompt = """
Write Robolectric unit tests for the following ViewModel:
```kotlin
[ViewModel code]
```
Requirements:
- Test initial UI state defaults.
- Test successful data load when repository returns items.
- Test error UI state when repository throws IOException.
- Use `StandardTestDispatcher` and `advanceUntilIdle()`.
                """.trimIndent(),
                whyImproved = "Specifies exact test cases (happy path, error path, initial state) and testing coroutine dispatcher conventions.",
                keyPoints = listOf(
                    "Instruct the AI to preserve external contracts when refactoring.",
                    "Explicitly demand negative, boundary, and exception test cases.",
                    "Use AI to draft KDoc and API documentation instantly."
                ),
                miniExercise = "Draft a prompt asking for unit tests covering integer division edge cases (division by zero, negative numbers, overflow).",
                miniExerciseHint = "Explicitly list the 3 edge cases and ask for `@Test(expected = ArithmeticException::class)`."
            )
        )
    )

    val module12 = CourseModule(
        id = "mod_12",
        number = 12,
        title = "AI for Content Creation",
        subtitle = "Hooks, Storytelling, Scripts, and Viral Copy",
        description = "Master high-converting copy, storytelling frameworks, YouTube scripts, social media hooks, and audience-first content workflows.",
        iconName = "Create",
        quizId = "quiz_12",
        lessons = listOf(
            Lesson(
                id = "m12_l1",
                moduleId = "mod_12",
                number = 1,
                title = "Viral Hooks & Copywriting Frameworks",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Apply time-tested copywriting frameworks (AIDA, PAS, BAB)",
                    "Craft high-converting hooks that halt feed scrolling",
                    "Eliminate AI cliches (e.g., 'In today's fast-paced world')"
                ),
                explanation = """
Most AI-generated content sounds robotic and monotonous because users don't specify copywriting frameworks.

**Core Frameworks to Command:**
1. **PAS (Problem - Agitate - Solve):**
   - *Problem:* Identify the acute frustration.
   - *Agitate:* Show how doing nothing makes it worse.
   - *Solve:* Introduce your solution as the relief.
2. **BAB (Before - After - Bridge):**
   - *Before:* The painful current state.
   - *After:* The dream future state.
   - *Bridge:* The tool or process that connects them.
3. **AIDA (Attention - Interest - Desire - Action):**
   - Universal advertising sequence for landing pages and promotional emails.

**Banned AI Cliches:**
Explicitly forbid: *"In today's fast-paced world"*, *"Delve into"*, *"Tapestry"*, *"Testament"*, *"Look no further"*.
                """.trimIndent(),
                badPrompt = "Write a social media post about our new time-tracking app.",
                improvedPrompt = """
Write a high-converting LinkedIn post for our new automated time-tracking mobile app.
Framework: Use the PAS (Problem-Agitate-Solve) structure.
- Hook: Bold contrarian statement about why manual spreadsheets waste 4 hours every Friday.
- Tone: Punchy, relatable, professional.
- Prohibited: Do not use the phrases 'game-changer', 'revolutionize', or 'in today's digital era'.
- Include a clear Call to Action (CTA) inviting comments.
                """.trimIndent(),
                whyImproved = "Applies PAS framework, gives a concrete hook angle, and bans tired corporate buzzwords.",
                keyPoints = listOf(
                    "Always anchor promotional copy in a proven framework (PAS, BAB, AIDA).",
                    "The hook determines 80% of content engagement.",
                    "Ban AI buzzwords to make text sound organic and human."
                ),
                miniExercise = "Write a prompt for an Instagram caption selling reusable insulated water bottles using the Before-After-Bridge (BAB) framework.",
                miniExerciseHint = "Before: Lukewarm water in plastic bottles; After: Ice-cold hydration after 12 hours; Bridge: Double-wall vacuum insulation."
            ),
            Lesson(
                id = "m12_l2",
                moduleId = "mod_12",
                number = 2,
                title = "Video Scripting & Storytelling",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Format two-column video scripts (Visual / Audio cues)",
                    "Maintain dynamic pacing and pattern interrupts",
                    "Structure storytelling arcs for YouTube and short-form video"
                ),
                explanation = """
Writing for video is fundamentally different from writing for print. Viewers listen with their ears while their eyes track motion.

**Two-Column Audio/Visual Script Format:**
When scripting for YouTube, Reels, or TikTok, instruct the AI to generate a 2-column table:
- **Left Column [Visual / Camera]:** B-roll, on-screen text, zooms, sound effects (SFX).
- **Right Column [Audio / Dialogue]:** Spoken narration, pacing pauses, vocal emphasis.

**Short-Form Retention Blueprint (60 seconds):**
- 0–3s: Visual + Verbal Hook (Shocking statement or problem).
- 4–15s: Stakes (Why this matters right now).
- 16–45s: Core Value (3 rapid-fire tips with on-screen text).
- 46–60s: Payoff + Loop or CTA.
                """.trimIndent(),
                badPrompt = "Write a YouTube video about productivity.",
                improvedPrompt = """
Create a 60-second YouTube Shorts script on 'The 2-Minute Rule for Procrastination'.
Format: 2-column Markdown table: | Visual / B-Roll / SFX | Spoken Dialogue |
Pacing: Fast, energetic, conversational.
Include explicit timestamps and a pattern interrupt every 10 seconds.
                """.trimIndent(),
                whyImproved = "Uses the industry-standard two-column AV format, specifies a exact 60-second constraint, and demands visual pacing cues.",
                keyPoints = listOf(
                    "Video scripts must include both Visual directions and Spoken audio.",
                    "Include pattern interrupts (zooms, text pops) every 8-12 seconds to sustain viewer retention.",
                    "Write for the ear: short conversational sentences that roll off the tongue naturally."
                ),
                miniExercise = "Draft a prompt requesting a 30-second TikTok script introducing a new study habit.",
                miniExerciseHint = "Request a 2-column table with timestamps: 0-5s Hook, 6-25s Value, 26-30s CTA."
            )
        )
    )
}
