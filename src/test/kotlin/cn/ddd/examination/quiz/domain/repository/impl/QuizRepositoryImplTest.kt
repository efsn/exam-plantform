package cn.ddd.examination.quiz.domain.repository.impl

import cn.ddd.examination.quiz.domain.model.entity.Quiz
import cn.ddd.examination.quiz.domain.model.vo.QuizBankId
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import cn.ddd.examination.quiz.infrastructure.repository.QuizMemoryRepository
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

internal class QuizRepositoryImplTest : StringSpec({

    val mock = mockk<QuizMemoryRepository>()
    val target = QuizRepositoryImpl(mock)
    val quiz = Quiz(QuizBankId("1"), QuizId("1"), Quiz.Type.BLANK, "subject", "A", "tony")

    "should get all quizzes" {
        every { mock.findAll() } returns listOf(quiz)
        target.findAll().size shouldBe 1
        verify(exactly = 1) { mock.findAll() }
    }
})