package cn.ddd.examination.quiz.application

import cn.ddd.examination.quiz.application.command.CreateQuizCommand
import cn.ddd.examination.quiz.application.command.toEntity
import cn.ddd.examination.quiz.domain.model.entity.Quiz
import cn.ddd.examination.quiz.domain.model.vo.QuizBankId
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import cn.ddd.examination.quiz.domain.repository.QuizRepository
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

internal class QuizApplicationServiceTest : StringSpec({

    val repo = mockk<QuizRepository>()
    val service = QuizApplicationService(repo)
    val quiz = Quiz(QuizBankId("1"), QuizId("1"), Quiz.Type.BLANK, "subject", "A", "tony")

    "should get all quizzes" {
        every { repo.findAll() } returns listOf(quiz)
        service.getAllQuizzes().size shouldBe 1
        verify(exactly = 1) { repo.findAll() }
    }

    "should get quiz by quiz id" {
        every { repo.find(any()) } returns quiz
        service.getQuiz("1").subject shouldBe "subject"
        verify { repo.find(QuizId("1")) }
    }

    "should create a quiz successfully" {
        every { repo.save(any()) } answers { nothing }
        val cmd = CreateQuizCommand("1", "BLANK", "", "", "")
        service.createQuiz(cmd) shouldBe Unit
        verify { repo.save(cmd.toEntity()) }
    }

    "should remove the quiz by id" {
        every { repo.remove(any()) } answers { nothing }
        service.removeQuiz("1") shouldBe Unit
        verify { repo.remove(QuizId("1")) }
    }
})