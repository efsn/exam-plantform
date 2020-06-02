package cn.ddd.examination.quiz.infrastructure.repository

import cn.ddd.examination.quiz.domain.model.entity.Quiz
import cn.ddd.examination.quiz.domain.model.vo.QuizBankId
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
internal class QuizMemoryRepositoryTest(
    private val repo: QuizMemoryRepository
) : StringSpec({

    "should save a quiz successfully" {
        val quiz = Quiz(QuizBankId("1"), QuizId("1"), Quiz.Type.BLANK, "subject", "A", "tony")
        repo.save(quiz) shouldBe Unit
    }
})