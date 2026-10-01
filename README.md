# AI Prompt Engineering – Full Course

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![Platform](https://img.shields.io/badge/platform-Android-green.svg)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-purple.svg)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-M3-brightgreen.svg)
![Room Database](https://img.shields.io/badge/Room-Offline%20First-orange.svg)

A complete, modern, production-grade Android application designed as a comprehensive beginner-to-advanced learning platform for **Prompt Engineering and Generative AI**.

---

## 🌟 Features & Highlights

- **18 Comprehensive Course Modules**:
  1. Introduction to Artificial Intelligence
  2. Generative AI Deep Dive
  3. Prompt Anatomy & Architecture
  4. Core Prompting Techniques (Zero-shot, Few-shot, Role, Context)
  5. Advanced Prompt Engineering (Chain-of-Thought, ReAct, Self-Consistency)
  6. Structured Prompting & System Prompts
  7. Output Control, Schemas & Formatting
  8. Prompt Debugging, Hallucinations & Failure Recovery
  9. Prompt Evaluation, Metrics & Benchmarks
  10. AI Agents, Tool Calling & Function Calling
  11. Multimodal AI (Image, Audio, Vision Prompts)
  12. AI Coding Prompts & Code Generation
  13. Image & Visual Generation Prompts (Midjourney/DALL-E/Flux)
  14. Video & Audio Prompting Techniques
  15. Business, Strategy & Enterprise Prompts
  16. Productivity & Workflow Automation
  17. Academic Research & Deep Analysis Prompts
  18. Advanced Architectures & Production Deployments

- **Interactive Prompt Playground & Live Evaluator**:
  - Test custom prompts with structured component builders (Role, Goal, Context, Constraints, Format, Examples).
  - Built-in heuristic evaluator providing instant multi-dimensional feedback:
    - Overall Score (0–100%)
    - Clarity & Specificity
    - Contextual Depth
    - Constraint Enforcement
    - Output Format Adherence
    - Actionable recommendations and suggested revisions.

- **Prompt Library**:
  - 11 curated categories: Education, Coding, Business, Marketing, Writing, Productivity, Research, Image Generation, Video Generation, Career, Social Media.
  - One-tap copy, favorite, share, and launch directly into Playground.

- **Interactive Quizzes & Certification**:
  - Module-level quizzes with immediate answer feedback and in-depth rationales.
  - Final 20-question comprehensive certification assessment.
  - Verified digital Certificate of Completion with learner name, date, credential ID, and social share options.

- **Real-World Guided Projects**:
  - Hands-on prompt projects (AI Study Tutor, Resume Analyzer, Code Refactoring Bot, Marketing Campaign Engine, Creative Image Director, Academic Research Synthesizer, etc.).

- **Offline-First Persistence**:
  - Powered by Room Database for zero-latency local progress tracking:
    - Completed lessons
    - Quiz results and scores
    - Saved / favorited prompts
    - Practice challenge submissions
    - User learning streak and achievement badges
  - Works 100% offline without requiring account creation or internet connection.

- **Modern Material 3 Design**:
  - Dynamic edge-to-edge support with safe window insets.
  - Dark Mode and Light Mode support.
  - Accessible touch targets (minimum 48dp).
  - Custom adaptive launcher icons.

---

## 🏗 Architecture & Tech Stack

- **UI**: 100% Jetpack Compose with Material 3 components
- **Architecture**: Clean MVVM (Model-View-ViewModel) + Repository Pattern
- **Language**: Kotlin 2.0+ (Coroutines & StateFlow)
- **Local Database**: Android Jetpack Room (KSP code generation)
- **Navigation**: Navigation Compose with type-safe state transitions & BackHandler support
- **Testing**: Robolectric local JVM testing for Critical User Journeys (CUJs)

---

## 🚀 Building & Running

### Requirements
- Android SDK 36 (Minimum SDK 24)
- Gradle 8.11+
- Java 17+

### Build Debug APK
```bash
gradle :app:assembleDebug
```
The output APK will be located at:
`app/build/outputs/apk/debug/app-debug.apk`

### Run Unit & Robolectric Tests
```bash
gradle :app:testDebugUnitTest
```

---

## 📱 Application Details
- **App Name**: AI Prompt Engineering
- **Package Name**: `com.aistudio.promptmaster.kxmqrv`
- **Version Name**: `1.0.0`
- **Version Code**: `1`
- **License**: Apache 2.0 / Educational Use
