package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.content.CourseData
import com.example.data.content.PromptLibraryData
import com.example.data.content.QuizData
import com.example.data.evaluator.PromptEvaluator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("AI Prompt Engineering", appName)
    }

    @Test
    fun `verify course curriculum structure`() {
        val modules = CourseData.modules
        assertEquals(18, modules.size)
        assertTrue(CourseData.totalLessonsCount >= 18)

        val firstModule = CourseData.getModule("mod_1")
        assertNotNull(firstModule)
        assertTrue(firstModule!!.lessons.isNotEmpty())

        val firstLesson = CourseData.getLesson("m1_l1")
        assertNotNull(firstLesson)
        assertEquals("What is Artificial Intelligence?", firstLesson!!.title)
    }

    @Test
    fun `verify prompt evaluator heuristics`() {
        val evaluation = PromptEvaluator.evaluatePrompt(
            prompt = "Explain quantum computing to a beginner in simple terms.",
            role = "Physicist",
            context = "High school classroom",
            constraints = "Under 100 words, no jargon",
            outputFormat = "Markdown bullet points"
        )

        assertTrue(evaluation.overallScore > 60)
        assertTrue(evaluation.clarityScore >= 50)
        assertTrue(evaluation.constraintsScore >= 50)
        assertTrue(evaluation.outputFormatScore >= 50)
        assertNotNull(evaluation.suggestedRevision)
    }

    @Test
    fun `verify prompt library categories and search`() {
        assertTrue(PromptLibraryData.templates.isNotEmpty())
        val codingTemplates = PromptLibraryData.getByCategory("Coding")
        assertTrue(codingTemplates.isNotEmpty())

        val searchResults = PromptLibraryData.searchPrompts("Kotlin")
        assertTrue(searchResults.isNotEmpty())
    }

    @Test
    fun `verify final certification assessment exists`() {
        val finalQuiz = QuizData.getQuiz("final_assessment")
        assertNotNull(finalQuiz)
        assertEquals(20, finalQuiz!!.questions.size)
    }
}
