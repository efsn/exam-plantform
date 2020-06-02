package cn.ddd.examination.paper.domain.repository

import cn.ddd.examination.paper.domain.model.entity.Paper
import cn.ddd.examination.paper.domain.model.entity.PaperId

interface PaperRepository {
    fun findByPaperId(paperId: PaperId): Paper?
    fun save(paper: Paper)
    fun findAll(): List<Paper>
}