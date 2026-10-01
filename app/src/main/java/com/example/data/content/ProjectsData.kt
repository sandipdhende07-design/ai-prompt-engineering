package com.example.data.content

import com.example.data.model.RealWorldProject

object ProjectsData {

    val projects: List<RealWorldProject> = listOf(
        RealWorldProject(
            id = "proj_1",
            title = "Build a Study Assistant Prompt",
            domain = "Education & Active Recall",
            objective = "Engineer a comprehensive interactive Socratic tutor prompt that guides students through complex STEM topics without giving away answers directly.",
            requirements = listOf(
                "Must incorporate the Socratic dialogue method (1 question per turn)",
                "Must include active recall and spaced repetition triggers",
                "Must include an error-correction loop using physical analogies",
                "Must feature a progress summary command"
            ),
            startingPrompt = "You are a study tutor. Help me learn physics and quiz me on motion.",
            improvementSteps = listOf(
                "Step 1: Assign a specific persona (Patient MIT Physics Teaching Assistant).",
                "Step 2: Define operational boundaries (Never reveal the formula before the student grasps intuition).",
                "Step 3: Establish the turn-taking protocol (Ask 1 question, evaluate answer, adjust difficulty).",
                "Step 4: Specify the review checkpoint format."
            ),
            finalPrompt = """
You are a patient physics mentor.
Subject: Classical Mechanics (Newtonian Motion).
Student Level: High School Senior / College Freshman.

Operating Rules:
1. Socratic Method: Never state the final formula or numerical answer directly.
2. Progressive Scaffolding: Lead the student step-by-step through first principles.
3. Turn Limit: Ask exactly ONE question per turn.
4. Error Handling: If the student errs, use a simple everyday physical analogy (e.g., throwing a baseball in a moving train) to challenge their logic.
5. Command 'STATUS': When the student types 'STATUS', provide a 3-bullet progress report of concepts mastered.
            """.trimIndent(),
            challenge = "Add a feature to this prompt that generates an Anki flashcard table at the conclusion of each study session.",
            expectedResult = "An engaging, turn-based tutor that prevents passive reading and drives deep intuitive comprehension."
        ),
        RealWorldProject(
            id = "proj_2",
            title = "Build a Resume Assistant Prompt",
            domain = "Career & Professional Growth",
            objective = "Construct an enterprise prompt that audits technical resumes against target job descriptions and rewrites bullets into Google X-Y-Z achievements.",
            requirements = listOf(
                "Extract matching and missing technical keywords",
                "Rewrite passive task descriptions into 'Accomplished [X], measured by [Y], by doing [Z]'",
                "Audit formatting and eliminate resume cliches",
                "Output as an Executive Readiness Scorecard"
            ),
            startingPrompt = "Improve my resume and make it look good for a software job.",
            improvementSteps = listOf(
                "Step 1: Add dual inputs for `{RESUME_TEXT}` and `{TARGET_JOB_DESCRIPTION}`.",
                "Step 2: Enforce Google's quantitative X-Y-Z formula for every bullet.",
                "Step 3: Add ATS (Applicant Tracking System) keyword gap analysis.",
                "Step 4: Structure output into a Markdown scorecard."
            ),
            finalPrompt = """
Role: Principal Technical Recruiter and Career Strategist.
Task: Audit and optimize the candidate's resume for the target role below.

<job_description>
{TARGET_JOB_DESCRIPTION}
</job_description>

<resume>
{RESUME_TEXT}
</resume>

Deliverables:
1. ATS Keyword Gap Analysis:
   - Matching Keywords Found (List)
   - Critical Missing Keywords (List)
2. Bullet Point Upgrades:
   - Identify 3 weakest bullets and rewrite each using Google's formula:
     'Accomplished [X], as measured by [Y], by doing [Z].'
3. Red Flags: Note any jargon, buzzwords, or unverified claims.
            """.trimIndent(),
            challenge = "Enforce a strict constraint that all metrics must be plausible and estimated conservatively without fabricating credentials.",
            expectedResult = "A high-precision resume audit that dramatically increases interview callback rates."
        ),
        RealWorldProject(
            id = "proj_3",
            title = "Build a Coding Assistant Prompt",
            domain = "Software Engineering",
            objective = "Develop a high-reliability prompt for Android architecture reviews, focusing on Jetpack Compose recomposition leaks and clean MVVM patterns.",
            requirements = listOf(
                "Declare language version and frameworks explicitly",
                "Diagnose memory leaks, state hoisting bugs, and threading violations",
                "Provide unit tests with StandardTestDispatcher",
                "Preserve public API contracts"
            ),
            startingPrompt = "Review my Kotlin code and tell me if it works.",
            improvementSteps = listOf(
                "Step 1: Set Senior Android Staff Architect persona.",
                "Step 2: Define exact evaluation dimensions (Performance, Threading, Clean Code).",
                "Step 3: Mandate that fixes include minimal diffs and unit tests."
            ),
            finalPrompt = """
Role: Senior Android Staff Architect.
Target Stack: Kotlin 2.0, Jetpack Compose M3, Room 2.7, Coroutines StateFlow.

Input Code:
```kotlin
{USER_CODE}
```

Audit Protocol:
1. Performance Check: Identify unnecessary recomposition triggers, unstable parameters, or missing `derivedStateOf`.
2. Concurrency Check: Verify background dispatchers for I/O and lifecycle-aware collection.
3. Clean Architecture: Verify unidirectional data flow (UDF).
4. Code Refactor: Provide the optimized code with KDoc documentation.
5. Unit Test: Provide a Robolectric test verifying the fix.
            """.trimIndent(),
            challenge = "Test this prompt against a Composable that performs database queries directly inside its composition body.",
            expectedResult = "Thorough architectural feedback preventing production crashes and battery drain."
        ),
        RealWorldProject(
            id = "proj_4",
            title = "Build a Content Generator Prompt",
            domain = "Marketing & Copywriting",
            objective = "Create a multi-channel content engine that transforms a raw 500-word blog post into a viral LinkedIn post, X thread, and newsletter blurb.",
            requirements = listOf(
                "Extract the core contrarian insight from source text",
                "Adapt tone and format per platform (LinkedIn vs X vs Email)",
                "Ban repetitive AI buzzwords and corporate cliches",
                "Include scroll-stopping hooks"
            ),
            startingPrompt = "Make some social media posts from this article.",
            improvementSteps = listOf(
                "Step 1: Define specific platform formats and constraints.",
                "Step 2: Inject copywriting frameworks (PAS, Before-After-Bridge).",
                "Step 3: Add explicit negative constraints against corporate filler."
            ),
            finalPrompt = """
Role: Direct-Response Growth Marketer.
Source Material:
<article>
{ARTICLE_TEXT}
</article>

Generate 3 multi-platform content assets:
1. LinkedIn Post:
   - Hook: Contrarian 1-sentence observation.
   - Body: 3 tactical bullet points with high white space.
   - CTA: Open-ended question inviting comments. No emojis.
2. X/Twitter Thread (4 tweets):
   - Tweet 1: Hook + curiosity gap.
   - Tweets 2-3: Core tactical takeaways.
   - Tweet 4: Synthesis + RT request.
3. Newsletter Summary: 80-word executive blurb with key takeaway bolded.
Constraint: Ban 'game-changer', 'delve', 'revolutionize', and 'in today's world'.
            """.trimIndent(),
            challenge = "Incorporate a hook-testing matrix that generates 5 alternative headline hooks for A/B testing.",
            expectedResult = "Clean, human-sounding multi-channel marketing copy ready for scheduling."
        ),
        RealWorldProject(
            id = "proj_5",
            title = "Build an Image Prompt Generator",
            domain = "Generative Visual Arts",
            objective = "Build a meta-prompt that takes a simple user concept and expands it into a master visual prompt using all 10 photographic parameters.",
            requirements = listOf(
                "Expand simple ideas into rich optical and cinematic terminology",
                "Specify camera body, lens focal length, aperture, and lighting setup",
                "Eliminate low-value buzzwords ('photorealistic', '8k')",
                "Output prompts formatted for Midjourney and Stable Diffusion"
            ),
            startingPrompt = "Make a prompt for a picture of a cyberpunk cat.",
            improvementSteps = listOf(
                "Step 1: Create a meta-prompt that functions as an Art Director.",
                "Step 2: Enforce the 10 Visual Parameters framework.",
                "Step 3: Provide 3 distinct stylistic variants (Cinematic Photo, 3D Octane, Vector Graphic)."
            ),
            finalPrompt = """
Role: Master AI Art Director and Cinematographer.
Task: Take the user's basic concept: '{USER_CONCEPT}' and generate 3 production-grade image prompts:

Option 1 - Cinematic Live-Action Photography:
- Specify subject details, camera body (e.g., Hasselblad, Arri Alexa), lens (e.g., 50mm f/1.2), volumetric lighting, color palette, atmosphere, and aspect ratio (--ar 16:9).

Option 2 - 3D Stylized Pixar / Octane Render:
- Specify materials (subsurface scattering, clay, vinyl), studio lighting, playful mood, and pastel background.

Option 3 - Editorial Risograph / Bauhaus Graphic:
- Specify two-color ink palette, retro paper grain texture, and bold geometric shapes.
Constraint: Do NOT use the words 'photorealistic', 'hyperrealistic', '8k', or 'trending on artstation'.
            """.trimIndent(),
            challenge = "Add negative prompt parameters (`--no watermark, blur, distorted hands`) to the output.",
            expectedResult = "Consistent, breathtaking image generations with precise artistic control."
        ),
        RealWorldProject(
            id = "proj_6",
            title = "Build a Research Assistant Prompt",
            domain = "Academic & Policy Analysis",
            objective = "Engineer an academic literature synthesis prompt that evaluates empirical methodology, flags bias, and extracts findings into comparative tables.",
            requirements = listOf(
                "Evaluate research methodology and sample validity",
                "Construct comparative matrices with author, year, method, and sample",
                "Distinguish correlation from causation",
                "Identify unaddressed limitations"
            ),
            startingPrompt = "Summarize these research papers for me.",
            improvementSteps = listOf(
                "Step 1: Set Senior Academic Peer Reviewer persona.",
                "Step 2: Mandate methodological rigor assessment.",
                "Step 3: Require tabular synthesis comparing findings side-by-side."
            ),
            finalPrompt = """
Role: Senior Academic Peer Reviewer and Epistemologist.
Analyze the following paper excerpts:
<papers>
{PAPER_EXCERPTS}
</papers>

Output Structure:
1. Methodology Matrix:
   | Study | Sample Size (N) | Method (RCT/Observational) | Primary Effect Size | Risk of Bias |
2. Areas of Consensus: What do the authors universally agree on?
3. Unresolved Debates: Where do findings directly conflict?
4. Methodological Critiques: What confounders or sampling limitations were omitted?
            """.trimIndent(),
            challenge = "Instruct the model to grade the empirical certainty of the overall conclusion on GRADE guidelines (High/Moderate/Low).",
            expectedResult = "High-level scientific synthesis suitable for graduate literature reviews."
        ),
        RealWorldProject(
            id = "proj_7",
            title = "Build a Customer Support Prompt",
            domain = "Customer Experience & Operations",
            objective = "Build an empathetic yet firm support prompt grounded in company refund policies with automated tier-escalation triggers.",
            requirements = listOf(
                "Strict grounding in company policy documents",
                "Empathetic, reassuring customer-facing tone",
                "Clear escalation triggers for human managers",
                "Zero authorization of unauthorized refunds"
            ),
            startingPrompt = "Answer customer emails about refunds.",
            improvementSteps = listOf(
                "Step 1: Inject company policy context in XML tags.",
                "Step 2: Add sentiment de-escalation framework.",
                "Step 3: Define escalation protocol for angry or litigious customers."
            ),
            finalPrompt = """
Role: Senior Customer Success Lead.
Tone: Warm, empathetic, professional, and clear.
Policy Source:
<policy>
{REFUND_POLICY}
</policy>

Customer Inquiry:
<inquiry>
{CUSTOMER_MESSAGE}
</inquiry>

Instructions:
1. De-escalate: Acknowledge the customer's frustration warmly in 1 sentence.
2. Resolution: Address their issue strictly according to <policy>.
3. Escalation Check: If customer threatens legal action, chargebacks, or social media exposure, do NOT argue. Provide polite holding text and append: '[ESCALATE_TIER_2]'.
4. Do not offer credits or refunds beyond explicit policy guidelines.
            """.trimIndent(),
            challenge = "Incorporate automated classification tags (e.g. `[ISSUE_TYPE: BILLING]`) at the very top of each response.",
            expectedResult = "Professional, compliant customer support that protects company policy while delighting users."
        ),
        RealWorldProject(
            id = "proj_8",
            title = "Build a Personal Productivity Assistant",
            domain = "Executive Coaching & Time Management",
            objective = "Construct a daily executive briefing prompt that processes calendar events, incoming tasks, and unread flags into a prioritized daily plan.",
            requirements = listOf(
                "Categorize into Deep Work, Shallow Work, and Meetings",
                "Apply the Eisenhower Matrix for urgent vs important tasks",
                "Identify energy management and buffer slots",
                "Generate an end-of-day reflection prompt"
            ),
            startingPrompt = "Plan my day with my calendar and to-do list.",
            improvementSteps = listOf(
                "Step 1: Set Executive Productivity Chief of Staff persona.",
                "Step 2: Block 90-minute uninterrupted deep work windows.",
                "Step 3: Flag cognitive overload and propose items to defer."
            ),
            finalPrompt = """
Role: Executive Chief of Staff and High-Performance Coach.
Inputs:
- Calendar Events: {CALENDAR_EVENTS}
- To-Do Brain Dump: {TODO_LIST}
- Current Energy Level: {ENERGY_LEVEL_1_TO_5}

Produce my Daily Battle Plan:
1. The 'One Big Thing': The single task that renders all other tasks easier or unnecessary.
2. Time-Blocked Schedule:
   - Morning Deep Work Block (90 min protected focus)
   - Meeting Clusters (batching communication)
   - Afternoon Shallow / Admin Block
3. Deferrals: 2 items from the to-do list that must be postponed to protect deep focus.
4. Daily Shutdown Ritual: 1 reflection question for 5:00 PM.
            """.trimIndent(),
            challenge = "Add automatic buffer calculation so that back-to-back meetings include mandatory 10-minute mental resets.",
            expectedResult = "An actionable, calm daily roadmap that prevents burnout and doubles high-leverage output."
        )
    )

    fun getProject(id: String): RealWorldProject? = projects.find { it.id == id }
}
