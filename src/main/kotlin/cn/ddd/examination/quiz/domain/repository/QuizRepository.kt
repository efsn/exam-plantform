package cn.ddd.examination.quiz.domain.repository

import cn.ddd.examination.quiz.domain.model.Quiz
import cn.ddd.examination.quiz.domain.model.QuizId

interface QuizRepository {
    fun findAll(): List<Quiz>
    fun find(quizId: QuizId): Quiz?
    fun save(quiz: Quiz)
    fun remove(quizId: QuizId)
}