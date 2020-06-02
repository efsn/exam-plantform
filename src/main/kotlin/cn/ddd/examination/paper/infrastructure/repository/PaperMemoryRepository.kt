package cn.ddd.examination.paper.infrastructure.repository

import cn.ddd.examination.paper.domain.model.entity.Paper
import cn.ddd.examination.paper.domain.model.entity.PaperId
import java.util.*
import javax.inject.Singleton

@Singleton
class PaperMemoryRepository {
    private val db = mutableMapOf<String, Paper>()

    fun findAll() = db.values.toList()

    fun findOnly(id: String) = db[id]

    fun save(paper: Paper) {
        val key = paper.paperId?.id ?: nextId()
        db[key] = paper.copy(paperId = PaperId(key))
    }

    private fun nextId() = "paper:${UUID.randomUUID()}"
}