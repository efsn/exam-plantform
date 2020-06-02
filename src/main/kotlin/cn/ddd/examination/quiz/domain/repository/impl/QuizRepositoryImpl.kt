package cn.ddd.examination.quiz.domain.repository.impl

import cn.ddd.examination.quiz.domain.model.entity.Quiz
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import cn.ddd.examination.quiz.domain.repository.QuizRepository
import cn.ddd.examination.quiz.infrastructure.repository.QuizMemoryRepository
import javax.inject.Singleton

@Singleton
class QuizRepositoryImpl(
    private val quizMemoryRepository: QuizMemoryRepository
) : QuizRepository {
    override fun findAll() = quizMemoryRepository.findAll()

    override fun find(quizId: QuizId) = quizMemoryRepository.findOnly(quizId.id)

    override fun save(quiz: Quiz) = quizMemoryRepository.save(quiz)

    override fun remove(quizId: QuizId) = quizMemoryRepository.delete(quizId.id)
}