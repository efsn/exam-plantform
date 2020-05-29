package cn.ddd.examination.quiz.application

import cn.ddd.examination.quiz.application.command.QuizCreateCommand
import cn.ddd.examination.quiz.application.command.toEntity
import cn.ddd.examination.quiz.domain.exception.QuizNotFoundException
import cn.ddd.examination.quiz.domain.model.QuizId
import cn.ddd.examination.quiz.domain.repository.QuizRepository
import javax.inject.Singleton

@Singleton
open class QuizApplicationService(
    private val repo: QuizRepository
) {
    fun getAllQuizzes() = repo.findAll()
    fun getQuiz(quizId: String) = repo.find(QuizId(quizId)) ?: throw QuizNotFoundException()
    fun createQuiz(command: QuizCreateCommand) = repo.save(command.toEntity())
    fun modifyQuiz(quizId: String, command: QuizCreateCommand) = repo.save(command.toEntity().copy(id = QuizId(quizId)))
    fun removeQuiz(id: String) = repo.remove(QuizId(id))
}