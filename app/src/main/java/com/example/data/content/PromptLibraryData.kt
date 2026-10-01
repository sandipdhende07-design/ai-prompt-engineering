package com.example.data.content

import com.example.data.model.PromptTemplate

object PromptLibraryData {

    val categories = listOf(
        "All",
        "Education",
        "Coding",
        "Business",
        "Marketing",
        "Writing",
        "Productivity",
        "Research",
        "Image Generation",
        "Video Generation",
        "Career",
        "Social Media"
    )

    val templates: List<PromptTemplate> = listOf(
        // Education
        PromptTemplate(
            id = "lib_edu_1",
            title = "Socratic Concept Tutor",
            category = "Education",
            description = "Interactive pedagogical guide that asks probing questions rather than spoon-feeding answers.",
            prompt = """
You are an expert Socratic tutor in [SUBJECT].
My current level of understanding is: [BEGINNER / INTERMEDIATE].
Topic: [INSERT TOPIC HERE]

Guidelines:
1. Do not lecture in long paragraphs.
2. Teach by asking me one thought-provoking question at a time.
3. If my answer is correct, validate it with a brief 1-sentence insight, then ask the next advancing question.
4. If my answer is incorrect or partial, challenge my underlying assumption with a simple everyday counter-example.
5. Wait for my response before continuing.
            """.trimIndent(),
            framework = "Socratic / Role",
            tags = listOf("Learning", "Tutoring", "Active Recall"),
            isFeatured = true
        ),
        PromptTemplate(
            id = "lib_edu_2",
            title = "Feynman Analogy Generator",
            category = "Education",
            description = "Translates complex abstract principles into simple physical analogies for a 12-year-old.",
            prompt = """
Explain [COMPLEX CONCEPT] using the Feynman Technique.
Target Audience: A 12-year-old middle school student.
Format:
1. Core Idea in 1 plain English sentence (zero jargon).
2. Everyday Physical Analogy (e.g., bicycle gears, plumbing, cooking).
3. How the Analogy maps to the real concept (3 bullet points).
4. One common misconception to avoid.
            """.trimIndent(),
            framework = "Feynman",
            tags = listOf("Mental Models", "Clarity", "Beginner")
        ),

        // Coding
        PromptTemplate(
            id = "lib_code_1",
            title = "Kotlin & Jetpack Compose Architect",
            category = "Coding",
            description = "Generates clean, idiomatic M3 Composable code with ViewModel and StateFlow patterns.",
            prompt = """
You are a Principal Android Engineer specializing in Kotlin 2.0 and Jetpack Compose.
Task: Create a production-ready Composable component for [FEATURE DESCRIPTION].

Requirements:
- Architecture: MVVM with M3 MaterialTheme and strict StateFlow state hoisting.
- State: Separate UI state into a sealed interface or data class with Loading, Success, Error states.
- Accessibility: Ensure all interactive targets meet 48.dp minimum touch size and have descriptive contentDescriptions.
- Performance: Avoid unnecessary recomposition; use remember and derivedStateOf where appropriate.
- Deliverable: Provide the UI state class, the ViewModel snippet, and the Composable function.
            """.trimIndent(),
            framework = "TCCO / Developer",
            tags = listOf("Android", "Kotlin", "Compose", "Architecture"),
            isFeatured = true
        ),
        PromptTemplate(
            id = "lib_code_2",
            title = "Cryptic Bug & Stacktrace Diagnostician",
            category = "Coding",
            description = "Analyzes complex error logs and proposes root cause diagnosis with minimal-diff fix.",
            prompt = """
Act as a Senior Debugging Specialist.
Analyze the following error stacktrace and source snippet.

Stacktrace:
```
[PASTE STACKTRACE HERE]
```

Code Context:
```
[PASTE CODE SNIPPET HERE]
```

Deliverables:
1. Root Cause: Exactly what line triggered the failure and why.
2. Underlying Flaw: Concurrency, memory leak, nullability, or lifecycle mismatch.
3. Proposed Fix: The exact code replacement with minimal invasive changes.
4. Prevention Rule: One unit test or lint check to prevent this regression.
            """.trimIndent(),
            framework = "Diagnosis-Fix",
            tags = listOf("Debugging", "Stacktrace", "Refactoring")
        ),

        // Business
        PromptTemplate(
            id = "lib_biz_1",
            title = "Executive Unit Economics Brief",
            category = "Business",
            description = "Evaluates business model feasibility, customer acquisition cost (CAC), and LTV ratios.",
            prompt = """
Role: Chief Financial Officer (CFO) and Venture Capital Partner.
Task: Evaluate the financial viability of [BUSINESS MODEL / PRODUCT CONCEPT].

Analyze:
1. Revenue Model: Pricing mechanics and margin structure.
2. Unit Economics: Estimated Customer Acquisition Cost (CAC) vs Lifetime Value (LTV) dynamics.
3. Key Operating Risks: The top 3 execution bottlenecks.
4. Strategic Moats: Defensibility against incumbent competitors.
Format: Executive briefing memo with bullet points and a concluding 'Go / No-Go' risk rating.
            """.trimIndent(),
            framework = "C-Suite / Memo",
            tags = listOf("Finance", "Strategy", "Startups"),
            isFeatured = true
        ),

        // Marketing
        PromptTemplate(
            id = "lib_mkt_1",
            title = "PAS High-Converting Landing Page Copy",
            category = "Marketing",
            description = "Crafts persuasive hero section copy using the Problem-Agitate-Solve framework.",
            prompt = """
You are a Direct-Response Conversion Copywriter.
Target Product: [PRODUCT NAME & PURPOSE]
Target Customer: [SPECIFIC BUYER PERSONA]

Write high-converting landing page copy using the Problem-Agitate-Solve (PAS) formula:
1. Hero Headline: Hook that names the acute frustration in under 10 words.
2. Agitation Paragraph: 3 sentences describing the hidden daily cost of ignoring this problem.
3. Solution Showcase: 3 bullet points highlighting tangible outcomes (not features).
4. High-Intent Call To Action (CTA): Button text with low perceived risk.
Constraint: Ban words like 'revolutionary', 'game changer', or 'innovative'.
            """.trimIndent(),
            framework = "PAS",
            tags = listOf("Copywriting", "Conversion", "SaaS")
        ),

        // Writing
        PromptTemplate(
            id = "lib_wri_1",
            title = "Technical Essay Editor & De-fluffer",
            category = "Writing",
            description = "Tightens prose, eliminates passive voice, and cuts conversational bloat by 30%.",
            prompt = """
You are an executive editor for an elite technical publication.
Review the draft below.
Goals:
1. Ruthlessly cut fluff, throat-clearing intros, and passive constructions.
2. Maintain the author's original thesis and technical accuracy.
3. Improve sentence variety and rhythmic cadence.

Draft:
\"\"\"
[INSERT DRAFT HERE]
\"\"\"

Output:
- Edited Version (with clean bold improvements)
- Changelog: 3 key editorial decisions made and why.
            """.trimIndent(),
            framework = "Editor Persona",
            tags = listOf("Editing", "Clarity", "Writing")
        ),

        // Productivity
        PromptTemplate(
            id = "lib_prod_1",
            title = "Eisenhower Matrix Prioritizer",
            category = "Productivity",
            description = "Sorts an overwhelming to-do brain dump into urgent vs important quadrants.",
            prompt = """
You are an executive productivity coach.
Below is my raw, unfiltered to-do list for this week:
[PASTE TO-DO BRAIN DUMP]

Task: Categorize every item into the Eisenhower Priority Matrix:
1. Quadrant 1 (Urgent & Important - Do Immediately)
2. Quadrant 2 (Not Urgent & Important - Schedule Deep Work)
3. Quadrant 3 (Urgent & Not Important - Delegate or Automate)
4. Quadrant 4 (Not Urgent & Not Important - Eliminate)

Highlight the single 'One Big Thing' that will create 80% of this week's progress.
            """.trimIndent(),
            framework = "Eisenhower Matrix",
            tags = listOf("Time Management", "Deep Work", "Prioritization")
        ),

        // Research
        PromptTemplate(
            id = "lib_res_1",
            title = "Literature Review Synthesizer",
            category = "Research",
            description = "Extracts methodological rigor, sample sizes, and empirical findings from papers.",
            prompt = """
Role: Senior Academic Research Assistant.
Topic: [RESEARCH TOPIC]
Context Material:
<literature>
[PASTE EXCERPTS OR ABSTRACTS]
</literature>

Instructions:
1. Construct a comparative literature matrix with columns: | Author/Year | Methodology | Sample Size | Core Finding | Limitations |
2. Identify areas of academic consensus across the sources.
3. Identify contradictions or unresolved debates between the authors.
4. Conclude with 2 promising directions for future empirical investigation.
            """.trimIndent(),
            framework = "Academic / Matrix",
            tags = listOf("Academic", "Synthesis", "Evidence")
        ),

        // Image Generation
        PromptTemplate(
            id = "lib_img_1",
            title = "Cinematic Studio Product Photo",
            category = "Image Generation",
            description = "Detailed optical parameters for photorealistic commercial product renders.",
            prompt = """
Commercial studio product photography of a [PRODUCT DESCRIPTION], placed elegantly on a matte obsidian pedestal. Soft directional key light from top-left, subtle electric cyan rim lighting tracing the silhouette edges. Shot on Hasselblad H6D-100c, 120mm macro f/4 lens, crisp razor-sharp focus on product textures, soft atmospheric background depth of field, luxury editorial catalog quality --ar 16:9
            """.trimIndent(),
            framework = "10 Visual Parameters",
            tags = listOf("Photography", "Midjourney", "Commercial")
        ),

        // Video Generation
        PromptTemplate(
            id = "lib_vid_1",
            title = "Cinematic Drone Tracking Shot",
            category = "Video Generation",
            description = "Camera vectors and physics continuity for text-to-video generative models.",
            prompt = """
Cinematic high-altitude drone tracking shot moving forward smoothly over a winding coastal highway carved into towering red sea cliffs at sunset.
Camera Movement: Slow, steady forward tracking shot at 24fps, slight downward tilt maintaining horizon line.
Atmosphere & Lighting: Deep golden hour illumination, crashing turquoise ocean waves leaving white foam trails below, gentle ocean mist catching the sun. Photorealistic physics continuity, high dynamic range.
            """.trimIndent(),
            framework = "Director Framework",
            tags = listOf("Runway", "Sora", "Cinematic", "Camera Movement")
        ),

        // Career
        PromptTemplate(
            id = "lib_car_1",
            title = "X-Y-Z Resume Bullet Optimizer",
            category = "Career",
            description = "Transforms weak job duties into high-impact Google-style achievement bullets.",
            prompt = """
You are a senior tech recruiter at a Tier-1 tech company.
I will give you a list of plain resume responsibilities.
Target Role: [TARGET JOB TITLE]

Rewrite each point into Google's X-Y-Z formula:
'Accomplished [X], as measured by [Y], by doing [Z].'

Raw Responsibilities:
[PASTE RESPONSIBILITIES]

Rules:
- Begin each bullet with a powerful past-tense action verb.
- Quantify impact with realistic metrics (percentages, hours saved, dollar value).
- Keep each bullet strictly under 25 words.
            """.trimIndent(),
            framework = "Google X-Y-Z",
            tags = listOf("Resume", "Interview", "Career Growth")
        ),

        // Social Media
        PromptTemplate(
            id = "lib_soc_1",
            title = "Viral X/Twitter Thread Architect",
            category = "Social Media",
            description = "Hooks, narrative pacing, and value-packed tweet threads for organic reach.",
            prompt = """
You are a viral ghostwriter for prominent founders and researchers.
Topic: [TOPIC / LESSON / CASE STUDY]

Write a 6-tweet thread following this viral blueprint:
Tweet 1 (The Hook): A counter-intuitive statement or bold revelation that stops the scroll. Include a 1-sentence teaser of what follows.
Tweet 2 (The Problem / Context): Why conventional wisdom is failing on this topic.
Tweets 3-5 (The Core Insights): 3 actionable frameworks or tactical steps. Use bullet points and high white space.
Tweet 6 (The Synthesis / Loop): A 1-sentence summary of the main takeaway, followed by a Call To Action asking readers for their perspective.
            """.trimIndent(),
            framework = "Thread Architecture",
            tags = listOf("Twitter", "Viral", "Hooks", "Audience")
        )
    )

    fun getByCategory(category: String): List<PromptTemplate> {
        if (category == "All") return templates
        return templates.filter { it.category.equals(category, ignoreCase = true) }
    }

    fun searchPrompts(query: String): List<PromptTemplate> {
        if (query.isBlank()) return templates
        val q = query.trim().lowercase()
        return templates.filter {
            it.title.lowercase().contains(q) ||
                it.category.lowercase().contains(q) ||
                it.description.lowercase().contains(q) ||
                it.prompt.lowercase().contains(q) ||
                it.tags.any { tag -> tag.lowercase().contains(q) }
        }
    }
}
