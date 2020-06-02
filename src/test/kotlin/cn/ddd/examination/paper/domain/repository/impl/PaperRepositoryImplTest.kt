package cn.ddd.examination.paper.domain.repository.impl

import cn.ddd.examination.paper.domain.model.entity.Paper
import cn.ddd.examination.paper.domain.model.entity.Paper.Quiz
import cn.ddd.examination.paper.domain.model.entity.PaperId
import cn.ddd.examination.paper.infrastructure.repository.PaperMemoryRepository
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

internal class PaperRepositoryImplTest : StringSpec({
    val mock = mockk<PaperMemoryRepository>()
    val target = PaperRepositoryImpl(mock)
    val paper = Paper(
        PaperId("1"), listOf(
            Quiz(QuizId("1"), 3),
            Quiz(QuizId("2"), 3),
            Quiz(QuizId("3"), 3),
            Quiz(QuizId("4"), 3),
            Quiz(QuizId("5"), 3)
        ), "1"
    )

    "should find paper by id" {
        every { mock.findOnly(any()) } returns paper
        target.findByPaperId(PaperId("1")) shouldBe paper
        verify { mock.findOnly("1") }
    }
})