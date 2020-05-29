package cn.ddd.examination.quiz.representation

import cn.ddd.examination.quiz.application.command.QuizCreateCommand
import cn.ddd.examination.quiz.domain.model.Quiz
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Patch
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client("/quizzes")
interface QuizClient {
    @Get
    fun getAll(): List<Quiz>

    @Get("/{quizId}")
    fun get(quizId: String): Quiz

    @Post
    fun createQuiz(command: QuizCreateCommand)

    @Patch("/{quizId}")
    fun updateQuiz(quizId: String, command: QuizCreateCommand)

    @Delete("/{quizId}")
    fun removeQuiz(quizId: String)
}