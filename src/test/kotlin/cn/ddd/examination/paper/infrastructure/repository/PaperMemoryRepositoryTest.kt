package cn.ddd.examination.paper.infrastructure.repository

import cn.ddd.examination.paper.domain.model.entity.Paper
import cn.ddd.examination.paper.domain.model.entity.PaperId
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
internal class PaperMemoryRepositoryTest(
    private val repo: PaperMemoryRepository
) : StringSpec({
    val paper = Paper(
        PaperId("1"), listOf(
            Paper.Quiz(QuizId("1"), 3),
            Paper.Quiz(QuizId("2"), 3),
            Paper.Quiz(QuizId("3"), 3),
            Paper.Quiz(QuizId("4"), 3),
            Paper.Quiz(QuizId("5"), 3)
        ), "1"
    )
    "should save paper successfully" {
        repo.save(paper) shouldBe Unit
    }
})