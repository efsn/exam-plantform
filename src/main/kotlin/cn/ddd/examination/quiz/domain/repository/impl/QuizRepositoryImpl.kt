package cn.ddd.examination.quiz.domain.repository.impl

import cn.ddd.examination.quiz.domain.model.Quiz
import cn.ddd.examination.quiz.domain.model.QuizId
import cn.ddd.examination.quiz.domain.repository.QuizRepository
import cn.ddd.examination.quiz.infrastructure.repository.MemoryQuizRepository
import javax.inject.Singleton

@Singleton
class QuizRepositoryImpl(
    private val memoryQuizRepository: MemoryQuizRepository
) : QuizRepository {
    override fun findAll() = memoryQuizRepository.getAll()

    override fun find(quizId: QuizId) = memoryQuizRepository.get(quizId.id)

    override fun save(quiz: Quiz) = memoryQuizRepository.save(quiz)

    override fun remove(quizId: QuizId) = memoryQuizRepository.delete(quizId.id)
}