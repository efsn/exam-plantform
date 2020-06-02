package cn.ddd.examination.paper.representation

import cn.ddd.examination.paper.application.PaperApplicationService
import cn.ddd.examination.paper.domain.exception.IllegalQuizzesCountException
import cn.ddd.examination.paper.domain.model.entity.Paper
import cn.ddd.examination.paper.domain.model.entity.PaperId
import io.kotlintest.shouldThrow
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
internal class PaperAPITest(
    private val paperApplicationService: PaperApplicationService,
    @Client("/papers") private val client: HttpClient
) : StringSpec({
    val paper = Paper(PaperId("1"), listOf(), "1")

    "should get all papers" {
        val mock = getMock(paperApplicationService)
        every { mock.getAllPapers() } returns listOf(paper)
        shouldThrow<IllegalQuizzesCountException> { client.toBlocking().retrieve("/", List::class.java) }
        verify { mock.getAllPapers() }
    }
}) {
    @MockBean
    fun paperApplicationService() = mockk<PaperApplicationService>()
}