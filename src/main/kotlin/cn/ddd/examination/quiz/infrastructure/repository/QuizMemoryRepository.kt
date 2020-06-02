package cn.ddd.examination.quiz.infrastructure.repository

import cn.ddd.examination.quiz.domain.model.entity.Quiz
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import java.util.*
import javax.inject.Singleton

@Singleton
class QuizMemoryRepository {
    private val db = mutableMapOf<String, Quiz>()

    fun findAll() = db.values.toList()

    fun findOnly(id: String) = db[id]

    fun save(quiz: Quiz) {
        val key = quiz.id?.id ?: nextId()
        db[key] = quiz.copy(id = QuizId(key))
    }

    fun delete(id: String) {
        db.remove(id)
    }

    private fun nextId() = "quiz:${UUID.randomUUID()}"
}