package cn.ddd.examination.quiz.representation

import cn.ddd.examination.quiz.application.QuizApplicationService
import cn.ddd.examination.quiz.representation.request.QuizCreateRequest
import cn.ddd.examination.quiz.representation.request.toCommand
import cn.ddd.examination.quiz.representation.response.toResponse
import io.micronaut.http.annotation.*

@Controller("quizzes")
class QuizAPI(
    private val service: QuizApplicationService
) {
    @Get
    fun getAll() = service.getAllQuizzes().map { it.toResponse() }

    @Get("{quizId}")
    fun get(quizId: String) = service.getQuiz(quizId).toResponse()

    @Post
    fun createQuiz(@Body request: QuizCreateRequest) = service.createQuiz(request.toCommand())

    @Patch("{quizId}")
    fun updateQuiz(quizId: String, @Body request: QuizCreateRequest) = service.modifyQuiz(quizId, request.toCommand())

    @Delete("{quizId}")
    fun removeQuiz(quizId: String) = service.removeQuiz(quizId)
}