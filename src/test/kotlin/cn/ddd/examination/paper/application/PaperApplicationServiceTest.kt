package cn.ddd.examination.paper.application

import cn.ddd.examination.paper.application.command.AssemblePaperCommand
import cn.ddd.examination.paper.application.command.AssemblePaperCommand.Quiz
import cn.ddd.examination.paper.domain.repository.PaperRepository
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.every
import io.mockk.mockk

internal class PaperApplicationServiceTest : StringSpec({
    val mock = mockk<PaperRepository>()
    val target = PaperApplicationService(mock)
    "should assemble paper successfully" {
        every { mock.save(any()) } answers { nothing }

        val cmd = AssemblePaperCommand(
            "1", listOf(
                Quiz("1", 3),
                Quiz("2", 3),
                Quiz("3", 3),
                Quiz("4", 3),
                Quiz("5", 3)
            )
        )
        target.assemblePaper(cmd) shouldBe Unit
//        verify { mock.save(cmd.toEntity()) }
    }
})