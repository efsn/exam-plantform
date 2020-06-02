package cn.ddd.examination.paper.representation

import cn.ddd.examination.paper.application.PaperApplicationService
import cn.ddd.examination.paper.representation.request.PaperAssembleRequest
import cn.ddd.examination.paper.representation.request.toCommand
import cn.ddd.examination.paper.representation.response.toResponse
import io.micronaut.http.annotation.*

@Controller("papers")
class PaperAPI(
    private val service: PaperApplicationService
) {

    @Post
    fun assemble(@Body request: PaperAssembleRequest) = service.assemblePaper(request.toCommand())

    @Get
    fun getAllPapers() = service.getAllPapers().map { it.toResponse() }

    @Patch("{paperId}")
    fun reassemble(paperId: String, @Body request: PaperAssembleRequest) = service.reassemblePaper(paperId, request.toCommand())
}