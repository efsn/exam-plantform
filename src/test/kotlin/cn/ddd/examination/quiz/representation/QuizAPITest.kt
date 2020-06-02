package cn.ddd.examination.quiz.representation

import cn.ddd.examination.quiz.application.QuizApplicationService
import cn.ddd.examination.quiz.domain.model.entity.Quiz
import cn.ddd.examination.quiz.domain.model.entity.Quiz.Type.BLANK
import cn.ddd.examination.quiz.domain.model.vo.QuizBankId
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotlintest.MicronautKotlinTestExtension.getMock
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

@MicronautTest
internal class QuizAPITest(
    private val quizApplicationService: QuizApplicationService,
    @Client("/quizzes") private val client: HttpClient
) : StringSpec({
    "should get all quizzes" {
        val mock = getMock(quizApplicationService)
        every { mock.getQuiz(any()) } returns Quiz(
            QuizBankId("1"),
            QuizId("1"),
            BLANK,
            "subject",
            "A",
            "tony"
        )
        client.toBlocking().retrieve("/1", Quiz::class.java) shouldNotBe null
        verify { mock.getQuiz("1") }
    }
}) {
    @MockBean
    fun quizApplicationService() = mockk<QuizApplicationService>()
}