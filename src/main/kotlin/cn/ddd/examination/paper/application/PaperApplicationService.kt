package cn.ddd.examination.paper.application

import cn.ddd.examination.paper.application.command.AssemblePaperCommand
import cn.ddd.examination.paper.application.command.toEntity
import cn.ddd.examination.paper.domain.exception.PaperNotFoundException
import cn.ddd.examination.paper.domain.model.entity.PaperId
import cn.ddd.examination.paper.domain.repository.PaperRepository
import javax.inject.Singleton

@Singleton
open class PaperApplicationService(
    private val paperRepository: PaperRepository
) {

    fun assemblePaper(command: AssemblePaperCommand) =
        paperRepository.save(command.toEntity())

    fun getAllPapers() = paperRepository.findAll()

    fun reassemblePaper(paperId: String, command: AssemblePaperCommand) {
        val paper = paperRepository.findByPaperId(PaperId(paperId)) ?: throw PaperNotFoundException()
        val quizzes = command.quizzes.map { it.toEntity() }
        paperRepository.save(paper.copy(quizzes = quizzes, teacherId = command.teacherId))
    }
}