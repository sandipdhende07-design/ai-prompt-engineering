package com.example.data.content

import com.example.data.model.CourseModule
import com.example.data.model.Lesson

object CourseModules1To6 {

    val module1 = CourseModule(
        id = "mod_1",
        number = 1,
        title = "Introduction to AI & Prompting",
        subtitle = "From Artificial Intelligence to Large Language Models",
        description = "Understand the foundational mechanics of Artificial Intelligence, Generative AI, Large Language Models (LLMs), and how prompt engineering bridges human intent and machine generation.",
        iconName = "Psychology",
        quizId = "quiz_1",
        lessons = listOf(
            Lesson(
                id = "m1_l1",
                moduleId = "mod_1",
                number = 1,
                title = "What is Artificial Intelligence?",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Define Artificial Intelligence and differentiate Narrow AI from General AI",
                    "Understand how modern AI systems process information and recognize patterns",
                    "Recognize AI in everyday applications from recommendations to voice assistants"
                ),
                explanation = """
Artificial Intelligence (AI) refers to computer systems designed to perform cognitive tasks traditionally requiring human intelligence. These tasks include visual perception, speech recognition, decision-making, pattern discovery, and language translation.

AI is generally categorized into two paradigms:
1. **Narrow AI (Weak AI):** Specialized algorithms trained to excel at a single specific domain (e.g., chess engines, spam filters, face unlock, or route optimization). All existing AI systems today belong to Narrow AI.
2. **Artificial General Intelligence (AGI):** Hypothetical machines capable of learning, reasoning, and generalizing across any intellectual task at human or superhuman parity.

Modern AI does not possess feelings, beliefs, or true sentience. Instead, it relies on complex statistical architectures that compute probabilities over vast datasets to generate relevant outputs.
                """.trimIndent(),
                badPrompt = "AI, tell me everything you can do.",
                improvedPrompt = "Define Artificial Intelligence in 3 concise bullet points for a high school student, and give 2 concrete everyday examples of Narrow AI.",
                whyImproved = "The improved prompt scopes the target audience, sets a strict format (3 bullet points), and limits the scope to everyday examples of Narrow AI.",
                keyPoints = listOf(
                    "AI is statistical pattern matching, not conscious thought.",
                    "All current commercial models are Narrow AI.",
                    "Clear instructions produce far more accurate outputs than broad inquiries."
                ),
                miniExercise = "Identify 3 tools on your phone that utilize Narrow AI and describe the single task each algorithm performs.",
                miniExerciseHint = "Think about your predictive keyboard, camera portrait mode, and map navigation."
            ),
            Lesson(
                id = "m1_l2",
                moduleId = "mod_1",
                number = 2,
                title = "What is Machine Learning & Deep Learning?",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Distinguish between classical programming and machine learning",
                    "Understand neural networks and deep learning layers",
                    "Grasp training data, weights, and loss functions"
                ),
                explanation = """
In traditional software development, programmers write explicit rules and logic: `If User is under 18, deny access`.

In **Machine Learning (ML)**, we invert this paradigm:
- Traditional: Data + Rules → Answers
- Machine Learning: Data + Answers → Rules

Instead of hand-coding every edge case, an ML model is exposed to thousands or billions of training examples. It iteratively adjusts mathematical coefficients called **weights** using optimization algorithms (like gradient descent) to minimize prediction errors measured by a **loss function**.

**Deep Learning** is a specialized branch of ML based on multi-layered Artificial Neural Networks inspired by biological brain architectures. Deep networks can automatically extract hierarchical features—moving from low-level edges to shapes, textures, words, and semantic meanings without manual feature engineering.
                """.trimIndent(),
                badPrompt = "Explain machine learning.",
                improvedPrompt = "Compare classical programming with machine learning using a 2-column markdown table: Column 1 = 'Dimension', Column 2 = 'Traditional Programming', Column 3 = 'Machine Learning'. Keep it beginner-friendly.",
                whyImproved = "Specifies a comparison table, labels exact headers, and calibrates difficulty for beginners.",
                keyPoints = listOf(
                    "Machine learning learns patterns and rules from historical data.",
                    "Deep learning uses multi-layer neural networks for complex data like text and images.",
                    "A model is fundamentally a frozen set of learned mathematical weights."
                ),
                miniExercise = "Explain in one sentence how an email spam filter learns to detect phishing emails without a human hardcoding every spam word.",
                miniExerciseHint = "Focus on analyzing large collections of labeled spam vs legitimate emails."
            ),
            Lesson(
                id = "m1_l3",
                moduleId = "mod_1",
                number = 3,
                title = "What is Generative AI?",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Contrast Discriminative AI with Generative AI",
                    "Understand the generation process across text, imagery, and code",
                    "Identify token-by-token sequence generation"
                ),
                explanation = """
For decades, most applied AI was **Discriminative** or analytical: it classified, scored, or predicted existing data (e.g., `Is this transaction fraudulent? Yes/No`).

**Generative AI** goes a transformative step further: given an initial input (called a **prompt**), it creates novel synthetic artifacts such as prose, computer code, high-resolution imagery, synthetic speech, or music.

At its core, a generative text model does not 'think' in whole paragraphs. It performs autoregressive token prediction:
Given tokens: `[The, quick, brown, fox, jumps, over, the]`
The model computes probability distributions over its entire vocabulary and predicts the most plausible next token: `[lazy]`.
It appends `lazy` to its context and repeats the cycle for the next token until a stopping condition is reached.
                """.trimIndent(),
                badPrompt = "Give me GenAI.",
                improvedPrompt = "Explain what Generative AI is by contrasting it with Predictive/Discriminative AI. Provide one real-world example of each in the healthcare industry.",
                whyImproved = "Uses contrastive explanation and grounds the concept in an explicit industry context (healthcare).",
                keyPoints = listOf(
                    "Discriminative AI categorizes; Generative AI synthesizes new content.",
                    "Text generation is autoregressive: predicting the most probable next token sequentially.",
                    "Generative AI does not retrieve pre-written answers; it constructs responses live."
                ),
                miniExercise = "List two tasks where you would prefer Discriminative AI over Generative AI, and explain why precision matters.",
                miniExerciseHint = "Consider medical lab test classification or fraud detection."
            ),
            Lesson(
                id = "m1_l4",
                moduleId = "mod_1",
                number = 4,
                title = "Large Language Models (LLMs) & Transformers",
                readingTimeMinutes = 7,
                objectives = listOf(
                    "Understand the Transformer architecture and self-attention mechanism",
                    "Understand tokens, vocabulary, and context windows",
                    "Recognize parameters and scaling laws"
                ),
                explanation = """
Large Language Models (LLMs) are massive deep neural networks trained on hundreds of billions or trillions of words of web text, literature, and code.

The revolutionary breakthrough behind LLMs was the **Transformer architecture** (introduced in Google's seminal 2017 paper *Attention Is All You Need*). The heart of the Transformer is the **Self-Attention mechanism**:
Instead of processing words strictly one-by-one from left to right, self-attention enables the model to look at all words in a prompt simultaneously and calculate mathematical relationships between them.

For example, in the sentence:
*The animal didn't cross the street because **it** was too tired.*
Self-attention connects **'it'** heavily to **'animal'**, while in:
*The animal didn't cross the street because **it** was too wide.*
It dynamically connects **'it'** to **'street'**.

**Key Terminology:**
- **Tokens:** Chunks of characters (~3/4 of an English word).
- **Context Window:** The maximum number of tokens a model can hold in memory at one time.
- **Parameters:** The tunable weights within the neural network (e.g., 7B, 70B, 1T+).
                """.trimIndent(),
                badPrompt = "What is a transformer in AI?",
                improvedPrompt = "Explain the Self-Attention mechanism in the Transformer architecture using the analogy of a cocktail party where people listen to specific voices. Keep it under 200 words.",
                whyImproved = "Specifies a memorable mental model (cocktail party analogy) and a strict length constraint.",
                keyPoints = listOf(
                    "The Transformer architecture powers virtually all modern language models.",
                    "Self-attention allows the model to understand contextual relationships between words across long sentences.",
                    "Models operate on sub-word tokens within a bounded context window."
                ),
                miniExercise = "Break down the word 'Unbelievable' into plausible sub-word tokens.",
                miniExerciseHint = "Tokens are often prefixes, roots, and suffixes: 'Un', 'believ', 'able'."
            ),
            Lesson(
                id = "m1_l5",
                moduleId = "mod_1",
                number = 5,
                title = "How Chatbots Work & Context Windows",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Understand stateless API requests vs multi-turn chat sessions",
                    "Learn how chat history is passed in every single API call",
                    "Manage context window limits and token degradation"
                ),
                explanation = """
A common misconception is that AI chatbots have an active, ongoing memory of you between messages.

In reality, **LLM inference is completely stateless**:
When you send message #5 in a chat, the application actually sends the *entire conversation history* back to the model:
`[System Prompt] + [User 1] + [Assistant 1] + [User 2] + [Assistant 2] + [User 3] ...`

As the conversation grows longer:
1. You consume more tokens on every round-trip.
2. Older instructions can suffer from 'middle-loss' or context fading.
3. If the chat exceeds the **Context Window**, earlier messages must be truncated or summarized.

Understanding this allows prompt engineers to recognize when to reset the chat thread or when to summarize critical context directly into a fresh prompt.
                """.trimIndent(),
                badPrompt = "Do you remember what I told you yesterday?",
                improvedPrompt = "Summarize the key decisions from our project discussion below into 4 action items with assignees. [Insert Context: ...]",
                whyImproved = "Injects explicit context directly into the stateless prompt rather than relying on assumed memory.",
                keyPoints = listOf(
                    "LLMs are stateless; multi-turn memory is simulated by passing chat history.",
                    "Long conversations consume token budgets and can dilute attention on early instructions.",
                    "Starting a fresh chat with a consolidated summary produces crisper responses."
                ),
                miniExercise = "Why might an AI chatbot suddenly forget a constraint you gave it 30 messages ago in the same chat?",
                miniExerciseHint = "Think about context window limits and sliding truncation."
            ),
            Lesson(
                id = "m1_l6",
                moduleId = "mod_1",
                number = 6,
                title = "AI Capabilities, Hallucinations & Limitations",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Identify the cognitive sweet spots of LLMs (synthesis, translation, refactoring)",
                    "Understand what causes hallucinations and fabricated facts",
                    "Recognize mathematical, temporal, and spatial reasoning limitations"
                ),
                explanation = """
Large Language Models are masters of **linguistic form and synthesis**, but they are not infallible calculation engines or knowledge databases.

**What LLMs excel at:**
- Synthesizing large volumes of text into structured notes.
- Translating between natural languages and programming languages.
- Brainstorming creative angles and roleplaying personas.
- Formatting raw data into JSON, Markdown, or CSV.

**Major Limitations:**
1. **Hallucination:** Because LLMs generate the most *statistically probable* tokens, they will confidently generate plausible-sounding falsehoods, fake book citations, non-existent API methods, or incorrect historical dates.
2. **Mental Math:** Standard autoregressive transformers struggle with arithmetic over multi-digit numbers unless given scratchpads or calculator tools.
3. **Knowledge Cutoffs:** The model only knows what was present in its pre-training dataset unless connected to retrieval systems (RAG) or web search.
                """.trimIndent(),
                badPrompt = "Give me citations of 5 research papers published in 2024 proving chocolate cures headaches.",
                improvedPrompt = "Search or analyze reputable medical consensus on cocoa flavonoids and headaches. If there is insufficient empirical evidence, explicitly state 'No definitive evidence found'. Do not fabricate studies.",
                whyImproved = "Explicitly instructs the model to admit ignorance and adds a negative constraint against fabrication.",
                keyPoints = listOf(
                    "Hallucination is a natural byproduct of next-token probability prediction.",
                    "Always add verification safeguards and give the model an 'escape hatch' to say 'I don't know'.",
                    "Never trust unverified citations or mathematical calculations without external validation."
                ),
                miniExercise = "Draft a 1-sentence prompt constraint that prevents an AI assistant from making up customer account numbers.",
                miniExerciseHint = "Use phrasing like 'If an account number is missing from the provided text, ask the user rather than guessing.'"
            ),
            Lesson(
                id = "m1_l7",
                moduleId = "mod_1",
                number = 7,
                title = "Introduction to Prompt Engineering",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Define Prompt Engineering as an empirical discipline",
                    "Understand why natural language is the ultimate programming interface",
                    "See the dramatic difference between naive queries and engineered prompts"
                ),
                explanation = """
**Prompt Engineering** is the practice of designing, structuring, refining, and optimizing natural language inputs to guide Generative AI models toward reliable, high-quality, and deterministic outputs.

Prompting is not magic or casual conversation. It is a form of software programming using natural language syntax:
- Just as code requires precise parameters, an LLM requires clear constraints.
- Vague prompts produce average, generic, or noisy outputs (the 'garbage in, garbage out' rule).
- Engineered prompts elicit the model's highest-tier analytical, creative, and technical capabilities.

Prompt engineering encompasses system architecture, role design, context feeding, constraint validation, few-shot prompting, and chain-of-thought orchestration.
                """.trimIndent(),
                badPrompt = "Write an essay about climate change.",
                improvedPrompt = "Act as an environmental economist. Write a 400-word policy brief for city council members proposing 3 municipal carbon reduction incentives. Format with an Executive Summary followed by 3 numbered initiatives with estimated fiscal impact.",
                whyImproved = "Specifies Role (economist), Audience (city council), Word Count (400 words), Topic (municipal incentives), and Exact Format (Executive Summary + Numbered initiatives).",
                keyPoints = listOf(
                    "Prompt engineering is programming in natural language.",
                    "Specificity and structured constraints eliminate ambiguity and reduce hallucinations.",
                    "An engineered prompt consistently yields 10x better outputs than naive prompts."
                ),
                miniExercise = "Transform the vague prompt 'Help me with my resume' into an engineered prompt specifying your target job, experience level, and preferred format.",
                miniExerciseHint = "Include: Target role, current background, desired focus sections, and action-verb emphasis."
            )
        )
    )

    val module2 = CourseModule(
        id = "mod_2",
        number = 2,
        title = "Prompt Engineering Fundamentals",
        subtitle = "The Universal Anatomy of an Effective Prompt",
        description = "Master the standard architectural components of an elite prompt: Role, Task, Context, Constraints, Output Format, and Examples.",
        iconName = "Architecture",
        quizId = "quiz_2",
        lessons = listOf(
            Lesson(
                id = "m2_l1",
                moduleId = "mod_2",
                number = 1,
                title = "What is a Prompt? Anatomy Overview",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Understand the fundamental architecture of an engineered prompt",
                    "Learn the 6 core components: Role + Task + Context + Constraints + Format + Examples",
                    "Analyze why missing components cause degraded outputs"
                ),
                explanation = """
A prompt is the comprehensive package of input instructions, background context, parameters, and examples provided to an LLM.

The universal high-performance prompt formula is:
**Role + Task + Context + Constraints + Output Format + Examples**

1. **Role (Who):** The persona or domain expertise the model adopts.
2. **Task (What):** The explicit action verb and primary objective.
3. **Context (Why / Where):** Background data, target audience, and business environment.
4. **Constraints (Boundaries):** What the model MUST NOT do, length bounds, tone rules.
5. **Output Format (Structure):** JSON, table, bullet points, Markdown schema.
6. **Examples (Few-Shot):** Concrete demonstrations of ideal input-output pairs.
                """.trimIndent(),
                badPrompt = "Write something about diet.",
                improvedPrompt = """
Role: Certified Sports Nutritionist.
Task: Create a 1-day sample meal plan for a 75kg marathon runner.
Context: Training phase is high-mileage peak week. Athlete is plant-based.
Constraints: Target 3,200 calories; minimum 120g protein; avoid processed sugar.
Output Format: Markdown table with columns: Meal, Food Items, Calories, Carbs(g), Protein(g).
                """.trimIndent(),
                whyImproved = "Implements all 5 structural elements, leaving zero ambiguity for the model to guess.",
                keyPoints = listOf(
                    "Structure guides probability distributions in the LLM.",
                    "Role primes specialized vocabulary and depth.",
                    "Constraints and output formats provide rigid boundaries."
                ),
                miniExercise = "Map the 6 components onto a prompt for writing a customer apology email for a delayed package shipment.",
                miniExerciseHint = "Role: Support Lead; Task: Write apology; Context: Blizzard delayed cargo; Constraints: Professional, no discount promises; Format: 3 paragraphs."
            ),
            Lesson(
                id = "m2_l2",
                moduleId = "mod_2",
                number = 2,
                title = "The Instruction / Task Element",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Write imperative, unambiguous task statements",
                    "Avoid passive or polite conversational filler",
                    "Sequence multiple sub-tasks logically"
                ),
                explanation = """
The **Instruction** is the operational engine of your prompt. It tells the model what action to execute.

**Common Mistakes:**
- Conversational filler: *"Hi, could you maybe please help me write something if you don't mind..."*
- Passive phrasing: *"Things regarding sales could be analyzed."*
- Conflating multiple disjointed requests into one run-on sentence.

**Best Practices:**
1. Start with an imperative command verb: `Summarize`, `Extract`, `Refactor`, `Evaluate`, `Synthesize`.
2. Place the primary instruction at either the very top or the very bottom of your prompt where attention weighting is strongest.
3. If multiple actions are required, break them into a numbered step sequence:
   - Step 1: Extract all dates and monetary figures.
   - Step 2: Calculate total expenditure.
   - Step 3: Highlight discrepancies exceeding $500.
                """.trimIndent(),
                badPrompt = "Can you look at this text and maybe find the dates or whatever else is important?",
                improvedPrompt = "Extract all dates, invoice numbers, and total dollar amounts from the text below. Output the findings in a bulleted list sorted chronologically.",
                whyImproved = "Direct imperative verb 'Extract', unambiguous scope, and clear sorting instructions.",
                keyPoints = listOf(
                    "Use direct imperative verbs.",
                    "Strip polite conversational fluff to preserve token weight.",
                    "Number complex multi-step instructions chronologically."
                ),
                miniExercise = "Rewrite 'I would like to have some ideas for blog posts about gardening' into an imperative, high-impact instruction.",
                miniExerciseHint = "Start with: 'Generate 10 viral blog post headlines focusing on organic urban balcony gardening.'"
            ),
            Lesson(
                id = "m2_l3",
                moduleId = "mod_2",
                number = 3,
                title = "Context Engineering Fundamentals",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Understand how context reduces hallucination",
                    "Distinguish between essential background and noise",
                    "Delimit external context cleanly using Markdown tags"
                ),
                explanation = """
Without context, the LLM must generate outputs based on generic global internet averages. When you inject rich, specific context, the model personalizes its response to your exact reality.

**Context includes:**
- Who the target reader is (e.g., 5th grade student vs board of directors).
- Prior history or events that led to this moment.
- Reference material, source documents, or product specifications.

**Delimiting Context:**
To prevent the model from confusing your instructions with the source text, use clear structural delimiters:
```
### INSTRUCTIONS:
Summarize the document below.

--- START DOCUMENT ---
[User document text here...]
--- END DOCUMENT ---
```
Using clear delimiters prevents **prompt leaking** and confusion.
                """.trimIndent(),
                badPrompt = "Summarize this article: The company was founded in 2010 by three engineers...",
                improvedPrompt = """
Summarize the following company history into 3 bullet points highlighting funding milestones and product launches.

<source_document>
The company was founded in 2010 by three engineers in Austin, Texas...
</source_document>
                """.trimIndent(),
                whyImproved = "Uses XML tags `<source_document>` to clearly isolate the input text from the instructions.",
                keyPoints = listOf(
                    "Context grounds the model in your specific scenario.",
                    "Use delimiters (XML tags, triple quotes, or Markdown dividers) to separate instructions from raw data.",
                    "Curate context: relevant facts help, but irrelevant noise distracts."
                ),
                miniExercise = "Create a prompt that uses triple backticks ``` to delimit a piece of messy user feedback you want categorized.",
                miniExerciseHint = "Write the categorization instructions first, then wrap the feedback block in ```."
            ),
            Lesson(
                id = "m2_l4",
                moduleId = "mod_2",
                number = 4,
                title = "The Power of Persona & Role Prompting",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Understand how role prompting alters token probability distributions",
                    "Craft multi-dimensional personas instead of flat job titles",
                    "Combine roles with expertise, biases, and evaluation standards"
                ),
                explanation = """
When you tell an LLM: *"You are an experienced cybersecurity auditor..."*, you are performing **latent space steering**.

The model contains trillions of connections. Stating a role primes the network to activate technical jargon, professional tone, skepticism, and industry-standard frameworks associated with that domain, while suppressing casual or irrelevant associations.

**Flat Role vs Rich Persona:**
- Flat: *"You are a lawyer."*
- Rich: *"You are a senior intellectual property attorney with 20 years of experience in open-source software licensing (GPL, Apache 2.0, MIT). You are cautious, detail-oriented, and highlight hidden legal liabilities."*

Notice how the rich persona defines experience level, specialization, temperament, and analytical focus.
                """.trimIndent(),
                badPrompt = "You are a fitness trainer. Give me advice.",
                improvedPrompt = "Act as an Olympic strength and conditioning coach specializing in post-injury rehabilitation for knee ligaments. Provide a conservative 4-week bodyweight progression plan.",
                whyImproved = "Defines specialization (Olympic level, post-ACL rehab) and sets a conservative, safety-conscious philosophy.",
                keyPoints = listOf(
                    "Roles steer the model toward specialized vocabulary and analytical depth.",
                    "Pair titles with specialization, years of experience, and tone.",
                    "Never rely on a role alone—always combine it with explicit instructions and constraints."
                ),
                miniExercise = "Write a 2-sentence rich persona for an AI that reviews beginner code and provides encouraging yet rigorous feedback.",
                miniExerciseHint = "Mention: patient senior software mentor, emphasis on clean code and readability, encouraging tone."
            ),
            Lesson(
                id = "m2_l5",
                moduleId = "mod_2",
                number = 5,
                title = "Constraints & Negative Prompting",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Apply positive and negative constraints effectively",
                    "Understand the 'Pink Elephant' problem in negative prompting",
                    "Use quantitative boundaries (word count, token limit, exclusions)"
                ),
                explanation = """
Constraints are boundaries that prevent the AI from drifting into undesirable behavior.

**Types of Constraints:**
1. **Length:** `Under 150 words`, `Exactly 3 paragraphs`, `Between 500 and 700 characters`.
2. **Exclusion:** `Do not mention competitors`, `Avoid passive voice`, `No introductory filler`.
3. **Tone:** `Objective and formal`, `Urgent and conversational`, `Humorous and playful`.
4. **Scope:** `Only reference information explicitly provided in the text`.

**The Pink Elephant Problem:**
If you say: *"Do NOT think of a pink elephant"*, the word 'pink elephant' is still injected into attention weights.
Similarly, in LLMs, writing: *"Do not make it sound boring and technical"* still primes the words 'boring' and 'technical'.
**Better approach:** Frame constraints positively when possible:
*Instead of:* "Don't write in a boring way."
*Use:* "Write in an energetic, engaging, conversational tone with punchy sentences."
                """.trimIndent(),
                badPrompt = "Write an announcement email. Don't make it too long and don't be boring.",
                improvedPrompt = """
Write an internal company announcement email introducing our new flexible work policy.
Constraints:
- Word count: strictly between 120 and 160 words.
- Tone: enthusiastic and transparent.
- Prohibited: Do not mention salary, benefits, or individual team exceptions.
- Do not include standard greetings like 'I hope this email finds you well'.
                """.trimIndent(),
                whyImproved = "Gives exact word bounds, sets positive tone descriptors, and explicitly bans specific forbidden topics.",
                keyPoints = listOf(
                    "Constraints prevent output bloat, bias, and off-topic drift.",
                    "Combine positive desired tone with explicit negative exclusions.",
                    "Specify exact quantitative bounds (word counts, bullet counts)."
                ),
                miniExercise = "Draft 3 constraints for an AI generating product descriptions for an eco-friendly water bottle.",
                miniExerciseHint = "Think about banned buzzwords ('revolutionary'), length limits, and verified material claims."
            ),
            Lesson(
                id = "m2_l6",
                moduleId = "mod_2",
                number = 6,
                title = "Output Format Specification",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Format outputs as JSON, Markdown, CSV, and structured tables",
                    "Understand schema enforcement for programmatic parsing",
                    "Eliminate conversational preamble and postamble"
                ),
                explanation = """
If you intend to use an AI's output inside an application, an Excel sheet, or a report, you must strictly dictate the output shape.

**Formats to master:**
- **Markdown Tables:** Ideal for quick side-by-side human reading.
- **Valid JSON:** Mandatory when piping AI outputs into mobile apps, backend APIs, or databases.
- **CSV:** Ideal for copying directly into spreadsheets.
- **Numbered Checklists:** Ideal for actionable operational procedures.

**Enforcing Pure Format:**
By default, models often add friendly chatter: *"Sure! Here is the JSON you requested: ... Let me know if you need anything else!"*
To eliminate this, append this strict constraint:
`Return ONLY valid JSON. Do not include any Markdown code blocks, introductory text, or concluding remarks.`
                """.trimIndent(),
                badPrompt = "Give me a list of European capitals and their populations.",
                improvedPrompt = """
List the 5 most populous capital cities in Europe.
Output format: A Markdown table with exactly 3 columns:
| City | Country | Population (Millions) |
Do not include any conversational greeting or concluding text.
                """.trimIndent(),
                whyImproved = "Defines table columns, exact row count, and suppresses conversational chit-chat.",
                keyPoints = listOf(
                    "Specify exact column names, JSON keys, or list structures.",
                    "Always explicitly command the model to suppress conversational wrappers if programmatic parsing is needed.",
                    "Structured formats make validation and comparison simple."
                ),
                miniExercise = "Write an output format instruction asking for an author, book title, and year published formatted as a valid JSON array of objects.",
                miniExerciseHint = "Specify the exact key names: `{\"title\": \"...\", \"author\": \"...\", \"year\": 0000}`."
            )
        )
    )

    val module3 = CourseModule(
        id = "mod_3",
        number = 3,
        title = "Core Prompting Techniques",
        subtitle = "Zero-Shot, Few-Shot, Chain-of-Thought & Beyond",
        description = "Master the industry-standard prompt methodologies: Zero-shot, One-shot, Few-shot demonstration, Role-playing, Step-by-step reasoning, and Delimiters.",
        iconName = "Bolt",
        quizId = "quiz_3",
        lessons = listOf(
            Lesson(
                id = "m3_l1",
                moduleId = "mod_3",
                number = 1,
                title = "Zero-Shot Prompting",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Understand Zero-shot learning and when it works best",
                    "Identify tasks where zero-shot fails due to ambiguity",
                    "Optimize zero-shot prompts with high clarity"
                ),
                explanation = """
**Zero-Shot Prompting** means presenting the AI with a task instruction without providing any examples of prior completed input-output pairs.

You rely solely on the model's pre-trained knowledge and instruction-following capability.

**When to use Zero-Shot:**
- Simple classifications (Positive/Negative sentiment).
- Broad summarization and translation.
- High-level brainstorming and ideation.
- Straightforward questions with clear boundaries.

**When it struggles:**
When the task requires a custom style, obscure domain convention, unusual formatting, or complex classification logic with edge cases.
                """.trimIndent(),
                badPrompt = "Classify this tweet: Loved the battery, hated the screen.",
                improvedPrompt = """
Classify the sentiment of the following customer tweet into exactly one of three categories: [Positive, Negative, Mixed].

Tweet: "Loved the battery, hated the screen."
Classification:
                """.trimIndent(),
                whyImproved = "Gives explicit candidate classes [Positive, Negative, Mixed] and prompts directly for the single label.",
                keyPoints = listOf(
                    "Zero-shot provides zero demonstration examples.",
                    "Works well for standardized tasks on capable modern models.",
                    "Provide closed-category options to avoid arbitrary answers."
                ),
                miniExercise = "Write a zero-shot prompt that classifies incoming customer support tickets as 'Billing', 'Technical', or 'General Inquiry'.",
                miniExerciseHint = "Define the categories and append the ticket text."
            ),
            Lesson(
                id = "m3_l2",
                moduleId = "mod_3",
                number = 2,
                title = "One-Shot & Few-Shot Prompting",
                readingTimeMinutes = 7,
                objectives = listOf(
                    "Learn how Few-Shot in-context learning works",
                    "Provide diverse, high-quality demonstration exemplars",
                    "Prevent exemplar bias and token inflation"
                ),
                explanation = """
**Few-Shot Prompting** is one of the most powerful prompt techniques discovered. Instead of just describing what you want, you provide 1 to 5 concrete examples of input-output pairs directly inside the prompt before presenting the new query.

Humans learn by example; LLMs are extraordinary pattern continuators.

**Structure of a Few-Shot Prompt:**
```
Convert customer complaints into actionable engineering bug tickets.

Example 1:
Input: "The checkout button won't click on Safari mobile!"
Ticket: [SEV-2][Checkout][iOS-Safari] Checkout CTA button unresponsive on touch event.

Example 2:
Input: "Where is my receipt? I never got an email."
Ticket: [SEV-3][Notification][Email] Receipt transactional email failed delivery.

New Input:
"App crashes immediately when I open my profile settings on Android 14."
Ticket:
```
The model immediately matches the exact bracketed tags, severity labels, and technical phrasing.
                """.trimIndent(),
                badPrompt = "Make tickets out of customer feedback.",
                improvedPrompt = "Use few-shot examples showing raw feedback converted into `[Priority][Feature] Description` syntax.",
                whyImproved = "Exemplars establish syntax, tone, and brevity without pages of wordy rules.",
                keyPoints = listOf(
                    "Few-shot prompting provides concrete input/output demonstrations.",
                    "2 to 3 well-chosen examples outperform pages of abstract rules.",
                    "Ensure your examples show diverse edge cases and maintain consistent formatting."
                ),
                miniExercise = "Write a 2-shot prompt that converts product descriptions into punchy 5-word marketing slogans.",
                miniExerciseHint = "Provide Example 1 (Product -> Slogan) and Example 2 (Product -> Slogan) before the target product."
            ),
            Lesson(
                id = "m3_l3",
                moduleId = "mod_3",
                number = 3,
                title = "Chain-of-Thought (CoT) Prompting",
                readingTimeMinutes = 7,
                objectives = listOf(
                    "Understand how Chain-of-Thought reasoning improves accuracy",
                    "Use Zero-shot CoT ('Let's think step by step')",
                    "Use Manual Few-shot CoT for multi-step math and logic"
                ),
                explanation = """
When a human solves a complex riddle or multi-step math problem, they don't blurt out the answer instantly; they write down scratch work.

If you ask an LLM a complex math or logic problem directly, it often answers incorrectly because it attempts to predict the final token in a single forward pass without intermediate computation tokens.

**Chain-of-Thought (CoT)** forces the model to generate intermediate reasoning steps before arriving at the final conclusion.

**The Famous Trigger Phrase:**
Appending: `"Let's think step by step"` or `"Work through the problem step-by-step before stating the final answer"` radically increases benchmark scores in logic, math, and coding.

When the model writes out Step 1 and Step 2 into its context window, those tokens become the working memory for calculating Step 3!
                """.trimIndent(),
                badPrompt = "A store has 20 apples. They sell half, then buy 5 more, then drop 3. What is the total?",
                improvedPrompt = """
Solve the following problem. First, write out your step-by-step arithmetic reasoning. Finally, state the final answer on a new line labeled 'Answer: '.

Problem: A store has 20 apples. They sell half, then buy 5 more, then drop 3. How many remain?
                """.trimIndent(),
                whyImproved = "Forces intermediate scratchpad reasoning before stating the final number.",
                keyPoints = listOf(
                    "Tokens are computation cycles; generating intermediate steps acts as scratchpad memory.",
                    "CoT dramatically cuts errors in arithmetic, logic puzzles, and legal analysis.",
                    "Prompt with 'Think step by step' or provide reasoning examples."
                ),
                miniExercise = "Create a CoT prompt to determine whether a person born on March 15, 2005 is eligible to rent a car in a state requiring age 21 as of October 2026.",
                miniExerciseHint = "Ask the model to compute current age in years and months before answering yes or no."
            ),
            Lesson(
                id = "m3_l4",
                moduleId = "mod_3",
                number = 4,
                title = "Step-by-Step Task Decomposition",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Break monolithic requests into sequential sub-tasks",
                    "Manage intermediate dependencies between tasks",
                    "Ensure quality control checkpoints at each phase"
                ),
                explanation = """
Asking an AI to *"Write a comprehensive 5-page research report with outline, sources, and executive summary"* in a single prompt usually results in a shallow, rushed 600-word response.

Complex cognitive work requires **Task Decomposition**:
Breaking a massive goal into explicit, sequential stages.

**Prompting with Decomposition:**
```
Perform this research task in 3 distinct sequential stages:

Stage 1 - Outline:
Create a hierarchical outline covering 4 key sub-topics.

Stage 2 - Arguments & Counter-Arguments:
For each sub-topic, list the primary empirical argument and the strongest counter-argument.

Stage 3 - Synthesis:
Draft the final executive summary based on the balance of evidence above.
```
By directing the model through sequential milestones, each section builds upon high-depth prior sections.
                """.trimIndent(),
                badPrompt = "Write a complete marketing strategy for my new coffee shop.",
                improvedPrompt = """
Create a marketing launch strategy for an independent specialty coffee shop in 4 sequential phases:
Phase 1: Target demographic profiles (Students, Remote workers, Commuters).
Phase 2: Pre-launch buzz campaign (Social, Local PR, Soft opening).
Phase 3: Grand Opening weekend activations and promotions.
Phase 4: 90-day retention and loyalty program design.
Provide 3 concrete tactics per phase.
                """.trimIndent(),
                whyImproved = "Breaks an overwhelming strategy into 4 chronologically structured phases with explicit deliverables.",
                keyPoints = listOf(
                    "Monolithic prompts yield superficial answers.",
                    "Decompose large projects into distinct phases, chapters, or milestones.",
                    "Explicitly instruct the model to finish each phase before moving to the next."
                ),
                miniExercise = "Decompose the task of 'Planning a week-long team engineering offsite' into 4 sequential stages.",
                miniExerciseHint = "Stage 1: Objectives & Agenda; Stage 2: Venue & Logistics; Stage 3: Hackathon Challenge; Stage 4: Post-Offsite Followup."
            )
        )
    )

    val module4 = CourseModule(
        id = "mod_4",
        number = 4,
        title = "Advanced Prompt Engineering",
        subtitle = "Schemas, Variables, JSON & System Prompts",
        description = "Engineer enterprise-grade prompts using JSON schemas, variable injection, system/developer prompts, and reliability techniques.",
        iconName = "Code",
        quizId = "quiz_4",
        lessons = listOf(
            Lesson(
                id = "m4_l1",
                moduleId = "mod_4",
                number = 1,
                title = "Prompt Templates & Variables",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Design reusable prompt templates with dynamic slot placeholders",
                    "Understand curly brace `{variable}` interpolation syntax",
                    "Build modular prompt libraries for scalable software"
                ),
                explanation = """
In production software, prompts are never static, hardcoded strings. They are **Prompt Templates** containing dynamic variables injected at runtime based on user actions.

**Standard Template Syntax:**
```
You are a career advisor reviewing a resume for the role of {TARGET_JOB_TITLE}.

Candidate Background:
{RESUME_TEXT}

Industry Requirements:
{INDUSTRY_REQUIREMENTS}

Analyze the resume against the target role. Provide:
1. Missing Keywords (matching {INDUSTRY_REQUIREMENTS})
2. 3 Bullet Points to strengthen using the X-Y-Z formula (Accomplished [X], measured by [Y], by doing [Z]).
```
Variables like `{TARGET_JOB_TITLE}` and `{RESUME_TEXT}` allow your application code to reuse the same tested prompt for millions of different users.
                """.trimIndent(),
                badPrompt = "Review this resume for a software engineer: [Pasted resume]",
                improvedPrompt = "Use a parametrized template with `{JOB_TITLE}`, `{EXPERIENCE_LEVEL}`, and `{RESUME_CONTENT}` placeholders.",
                whyImproved = "Transforms a single-use prompt into a reusable software asset.",
                keyPoints = listOf(
                    "Templates decouple prompt logic from dynamic runtime data.",
                    "Use consistent delimiters for variables, such as `{VARIABLE}` or `{{variable}}`.",
                    "Test your templates with extreme edge-case values (empty text, very long text)."
                ),
                miniExercise = "Design a reusable prompt template for drafting automated customer review replies with variables for `{CUSTOMER_NAME}`, `{RATING_STARS}`, and `{REVIEW_COMMENT}`.",
                miniExerciseHint = "Write the static instructions and include the 3 variables in uppercase curly brackets."
            ),
            Lesson(
                id = "m4_l2",
                moduleId = "mod_4",
                number = 2,
                title = "JSON Prompting & Structured Outputs",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Force LLMs to return strict valid JSON matching a schema",
                    "Define key types, enums, and required fields",
                    "Handle JSON syntax repair and escaping"
                ),
                explanation = """
When connecting an LLM to a frontend Android app, an iOS app, or a database, receiving freeform Markdown is unusable. You need parseable JSON.

**Techniques for Perfect JSON:**
1. Provide a TypeScript interface or JSON Schema inside the prompt.
2. Provide a 1-shot example of the exact JSON output.
3. Explicitly list allowed Enum values (e.g., `status: "approved" | "pending" | "rejected"`).
4. Add the negative constraint: `Return ONLY raw JSON. Do not wrap in backticks or markdown.`

**Example Schema in Prompt:**
```
Analyze this user feedback. Return a JSON object with this exact shape:
{
  "sentiment": "POSITIVE" | "NEGATIVE" | "NEUTRAL",
  "urgencyScore": 1-5,
  "category": "BILLING" | "BUG" | "FEATURE_REQUEST",
  "summary": "1 sentence summary"
}
```
                """.trimIndent(),
                badPrompt = "Extract information from this email in JSON.",
                improvedPrompt = """
Extract transaction details from the receipt below into valid JSON matching this schema:
{
  "vendor": string,
  "totalAmount": number,
  "currency": string (ISO 4217 code),
  "items": [{"name": string, "price": number}]
}
Receipt: [Text]
Return ONLY the raw JSON object.
                """.trimIndent(),
                whyImproved = "Gives exact schema, field types, and suppresses markdown formatting.",
                keyPoints = listOf(
                    "Define exact keys, types, and allowed enum values in the prompt.",
                    "Specify that the response must be valid JSON without conversational wrapper text.",
                    "Always validate and handle JSON parse exceptions in your application code."
                ),
                miniExercise = "Write a JSON prompt schema for extracting a flight itinerary (Airline, Flight Number, Departure Time, Arrival Time, Gate).",
                miniExerciseHint = "Structure a JSON object with flightDetails containing string and number fields."
            ),
            Lesson(
                id = "m4_l3",
                moduleId = "mod_4",
                number = 3,
                title = "Hallucination Reduction & Fact Grounding",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Understand RAG (Retrieval-Augmented Generation) concepts",
                    "Ground responses strictly in provided reference text",
                    "Build epistemic humility constraints into system instructions"
                ),
                explanation = """
To prevent an LLM from inventing facts, you must **ground** it in authoritative reference material and explicitly give it permission to admit when information is missing.

**The Grounding Recipe:**
1. **Provide the Context:** Supply the authoritative text inside `<context>` tags.
2. **Strict Grounding Rule:** `Answer the question based SOLELY on the provided context. Do NOT use outside knowledge.`
3. **The 'I Don't Know' Escape Hatch:** `If the answer cannot be directly determined from the provided text, respond with: 'The provided document does not contain this information.'`
4. **Citation Requirement:** `For every claim you make, quote the exact sentence from the source text.`

Without the escape hatch, an LLM feels statistical pressure to invent a plausible answer rather than admit ignorance.
                """.trimIndent(),
                badPrompt = "What is our company's refund policy on opened digital goods?",
                improvedPrompt = """
You are a customer support agent. Answer the user question based EXCLUSIVELY on the company policy below.
If the policy does not explicitly mention the scenario, state: "I cannot find this in our policy. Please contact human support."
Do NOT assume or infer rules outside the text.

<policy>
[Pasted policy...]
</policy>

User Question: What is the refund policy on opened digital goods?
                """.trimIndent(),
                whyImproved = "Strict grounding, explicit ban on external inferences, and predefined fallback sentence.",
                keyPoints = listOf(
                    "Grounding forces the model to treat your provided context as the sole source of truth.",
                    "Always provide an explicit fallback phrase when evidence is lacking.",
                    "Asking for direct source quotes significantly suppresses hallucinations."
                ),
                miniExercise = "Draft a system instruction for a medical FAQ bot that mandates it to recommend consulting a doctor whenever an exact symptom is not listed.",
                miniExerciseHint = "Include an explicit clause: 'If a symptom is not explicitly listed, refuse diagnosis and advise seeing a physician.'"
            )
        )
    )

    val module5 = CourseModule(
        id = "mod_5",
        number = 5,
        title = "AI Role Prompting",
        subtitle = "Mastering Specialized Personas",
        description = "Learn how to build high-impact domain personas: Teacher, Software Architect, Marketing Strategist, Legal Researcher, and UX Designer.",
        iconName = "Badge",
        quizId = "quiz_5",
        lessons = listOf(
            Lesson(
                id = "m5_l1",
                moduleId = "mod_5",
                number = 1,
                title = "The Architecture of a High-Impact Persona",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Move beyond shallow job titles into multi-dimensional personas",
                    "Define professional ethos, cognitive biases, and communication habits",
                    "Pair roles with concrete instructions and output standards"
                ),
                explanation = """
A basic role prompt like *"You are a teacher"* barely scratches the surface. What kind of teacher? Socratic university professor? Patient kindergarten educator? Strict bootcamp instructor?

**The 5 Pillars of an Enterprise Persona:**
1. **Domain & Credential:** *"You are an experienced Stanford professor of cognitive neuroscience with 15 years of lab research."*
2. **Tone & Manner:** *"You are intellectually rigorous, articulate, intellectually humble, and avoid buzzwords."*
3. **Methodology:** *"You teach using Socratic questioning, leading the student to the answer rather than simply providing it."*
4. **Target Audience:** *"Your student is a curious undergraduate with introductory psychology knowledge."*
5. **Quality Standards:** *"You always ground your claims in peer-reviewed neurological mechanisms (synaptic plasticity, dopamine pathways)."*
                """.trimIndent(),
                badPrompt = "You are a teacher. Teach me about memory.",
                improvedPrompt = """
You are a distinguished cognitive science professor.
Your teaching method is Socratic: do not lecture in long walls of text. Instead:
1. Explain one foundational concept of memory consolidation in 2 sentences.
2. Ask the student one thought-provoking question to test their understanding.
3. Wait for the student's response before proceeding.
                """.trimIndent(),
                whyImproved = "Defines a pedagogical technique (Socratic) and constrains response length into interactive turns.",
                keyPoints = listOf(
                    "Deep personas define methodology, not just job titles.",
                    "Socratic roles create engaging, turn-by-turn learning experiences.",
                    "Specify how the persona handles mistakes and questions."
                ),
                miniExercise = "Write a 3-sentence persona for a Senior Android Architect conducting a code review of a junior developer's Jetpack Compose code.",
                miniExerciseHint = "Mention: Focus on recomposition performance, architecture patterns (M3/MVVM), and constructive, kind feedback."
            ),
            Lesson(
                id = "m5_l2",
                moduleId = "mod_5",
                number = 2,
                title = "The 5 Core Professional Roles in Action",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Examine production-ready personas across 5 major career fields",
                    "Observe how vocabulary and focus shift dynamically",
                    "Adapt role templates for your own daily workflows"
                ),
                explanation = """
Let's analyze 5 production personas across major industries:

**1. Software Developer:**
*"You are a Staff Software Engineer specializing in Kotlin and Android. You prioritize Clean Architecture, type safety, testability, and edge-case handling. When reviewing code, you identify memory leaks, recomposition traps, and concurrency bugs."*

**2. Marketing Strategist:**
*"You are a Direct-Response Growth Marketer with deep experience in SaaS customer acquisition. You focus on hook rate, conversion funnels, customer pain points, and high-converting CTAs. You ruthlessly cut generic corporate jargon."*

**3. Research Assistant:**
*"You are a PhD Academic Research Assistant. You are epistemically rigorous, distinguish correlation from causation, evaluate sample sizes, and summarize methodology before findings."*

**4. UI/UX Designer:**
*"You are a Principal Product Designer specializing in accessibility (WCAG 2.1 AA), design systems (Material 3), touch targets, and visual hierarchy. You critique layouts based on cognitive load and user friction."*

**5. Executive Business Coach:**
*"You are an executive coach to Fortune 500 CEOs. You ask incisive questions about unit economics, team leverage, opportunity costs, and strategic moats."*
                """.trimIndent(),
                badPrompt = "Act as a marketer and check my website text.",
                improvedPrompt = """
Act as a SaaS Conversion Rate Optimization (CRO) specialist.
Audit the following landing page Hero Section headline and sub-headline:
Headline: "We provide innovative AI solutions for modern businesses."
Sub-headline: "Our cutting-edge platform streamlines workflows and enhances synergy."

Provide:
1. Diagnosis of why this copy fails to convert.
2. 3 alternative headlines using the 'Pain-Agitate-Solution' framework.
                """.trimIndent(),
                whyImproved = "Applies a specific marketing framework (CRO / PAS) to concrete bad copy.",
                keyPoints = listOf(
                    "Each professional role activates a distinct mental toolkit and analytical vocabulary.",
                    "Request specific industry frameworks (e.g., WCAG for UI, CRO for marketing).",
                    "Pair persona evaluation with concrete, actionable rewrite recommendations."
                ),
                miniExercise = "Pick one of the 5 roles above and draft a prompt solving a problem you encountered this week.",
                miniExerciseHint = "Clearly state the role, provide the problem details, and request specific recommendations."
            )
        )
    )

    val module6 = CourseModule(
        id = "mod_6",
        number = 6,
        title = "Context Engineering",
        subtitle = "Mastering the Information Diet of an AI",
        description = "Learn how to assemble, prioritize, and structure external context, reference documents, and user constraints to achieve pinpoint accuracy.",
        iconName = "Layers",
        quizId = "quiz_6",
        lessons = listOf(
            Lesson(
                id = "m6_l1",
                moduleId = "mod_6",
                number = 1,
                title = "Why Context Matters & Context Prioritization",
                readingTimeMinutes = 6,
                objectives = listOf(
                    "Understand how context changes token probabilities",
                    "Learn Context Prioritization (The 'Lost in the Middle' phenomenon)",
                    "Structure long prompts for maximum attentional weighting"
                ),
                explanation = """
In generative models, **attention** is finite and distributed across all tokens in the context window.

Researchers discovered the **'Lost in the Middle' phenomenon**:
LLMs recall information placed at the very beginning (Primacy bias) and the very end (Recency bias) of a long prompt with much higher fidelity than information buried in the middle of a 10,000-token prompt.

**Optimal Prompt Ordering:**
1. **Top (Primacy):** High-level Role, primary objective, and core constraints.
2. **Middle (Body):** Raw reference material, documents, tabular data, and background logs.
3. **Bottom (Recency):** The specific immediate user query, output formatting instructions, and final trigger.

Placing the final command at the very bottom ensures it has maximum weight when generation begins.
                """.trimIndent(),
                badPrompt = "Here is 20 pages of text. [20 pages]. Summarize it.",
                improvedPrompt = """
You are an executive intelligence analyst.
Objective: Extract all key security risks mentioned in the report below.

=== REFERENCE REPORT START ===
[Report text here...]
=== REFERENCE REPORT END ===

Final Instructions:
Based solely on the report above:
1. List the top 3 cybersecurity vulnerabilities identified.
2. Format as a bulleted risk register with Severity (High/Med/Low).
                """.trimIndent(),
                whyImproved = "Positions critical instructions at the top and bottom, sandwiching the reference text cleanly in the middle.",
                keyPoints = listOf(
                    "Information in the middle of long prompts can suffer from attentional degradation.",
                    "Place core instructions at the top and the final command at the bottom.",
                    "Clear section dividers help the model navigate complex documents."
                ),
                miniExercise = "Rearrange a disorganized prompt containing background data, instructions, and role into the optimal Primacy-Body-Recency order.",
                miniExerciseHint = "1. Role & Goal -> 2. Background Document -> 3. Output Format & Action."
            ),
            Lesson(
                id = "m6_l2",
                moduleId = "mod_6",
                number = 2,
                title = "Handling Large Contexts & Noise Reduction",
                readingTimeMinutes = 5,
                objectives = listOf(
                    "Filter out noise before passing data to an LLM",
                    "Summarize long histories to preserve token budget",
                    "Prevent conflicting contextual facts"
                ),
                explanation = """
Modern models have context windows of 128k, 1M, or even 2M tokens. However, just because you *can* paste an entire 500-page book doesn't mean you *should*.

**The Cost of Context Bloat:**
1. **Increased Latency:** Larger prompts take significantly longer to process (Time-To-First-Token).
2. **Higher Monetary Cost:** API token fees scale linearly with context size.
3. **Diluted Focus:** Irrelevant tangents increase the probability of false correlations and hallucinations.

**Noise Reduction Strategies:**
- Pre-filter: Strip boilerplate HTML, repetitive email signatures, and legal disclaimers before prompting.
- Chunk and Map-Reduce: Summarize individual sections first, then run a meta-summary prompt over the section summaries.
- Keep context strictly relevant to the task at hand.
                """.trimIndent(),
                badPrompt = "Here is my entire codebase. Fix the bug on line 42.",
                improvedPrompt = """
Fix the NullPointerException occurring in `UserProfileViewModel.kt`.
Below is the ViewModel class and the corresponding `UserRepository` interface.
No other files are required.

[Pasted UserProfileViewModel.kt]
[Pasted UserRepository.kt]
                """.trimIndent(),
                whyImproved = "Isolates only the two relevant files instead of overloading the model with an entire project.",
                keyPoints = listOf(
                    "More context is not always better; relevant context is what counts.",
                    "Clean raw inputs by removing boilerplate and noise.",
                    "Chunk and synthesize massive documents before final processing."
                ),
                miniExercise = "What pre-processing steps would you take before feeding 50 customer service chat logs to an AI to identify common complaints?",
                miniExerciseHint = "Remove greetings, timestamps, agent signatures, and personal identifiable info (PII)."
            )
        )
    )
}
