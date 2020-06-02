package cn.ddd.examination.paper.domain.repository.impl

import cn.ddd.examination.paper.domain.model.entity.Paper
import cn.ddd.examination.paper.domain.model.entity.PaperId
import cn.ddd.examination.paper.domain.repository.PaperRepository
import cn.ddd.examination.paper.infrastructure.repository.PaperMemoryRepository
import javax.inject.Singleton

@Singleton
class PaperRepositoryImpl(
    private val memoryRepository: PaperMemoryRepository
) : PaperRepository {

    override fun findByPaperId(paperId: PaperId) = memoryRepository.findOnly(paperId.id)

    override fun save(paper: Paper) = memoryRepository.save(paper)

    override fun findAll() = memoryRepository.findAll()
}