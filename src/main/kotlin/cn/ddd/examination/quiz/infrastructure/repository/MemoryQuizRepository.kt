package cn.ddd.examination.quiz.infrastructure.repository

import cn.ddd.examination.quiz.domain.model.Quiz
import cn.ddd.examination.quiz.domain.model.QuizId
import java.util.*
import javax.inject.Singleton

@Singleton
class MemoryQuizRepository {
    private val db = mutableMapOf<String, Quiz>()

    fun getAll() = db.values.toList()

    fun get(id: String) = db[id]

    fun save(quiz: Quiz) {
        val key = quiz.id?.id ?: nextId()
        db[key] = quiz.copy(id = QuizId(key))
    }

    fun delete(id: String) {
        db.remove(id)
    }

    private fun nextId() = "quiz:${UUID.randomUUID()}"
}