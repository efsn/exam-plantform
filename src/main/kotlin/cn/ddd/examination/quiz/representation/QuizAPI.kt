package cn.ddd.examination.quiz.representation

import cn.ddd.examination.quiz.application.QuizApplicationService
import cn.ddd.examination.quiz.application.command.QuizCreateCommand
import io.micronaut.http.annotation.*

@Controller("quizzes")
class QuizAPI(
    private val service: QuizApplicationService
) {
    @Get
    fun getAll() = service.getAllQuizzes()

    @Get("{quizId}")
    fun get(quizId: String) = service.getQuiz(quizId)

    @Post
    fun createQuiz(@Body command: QuizCreateCommand) = service.createQuiz(command)

    @Patch("{quizId}")
    fun updateQuiz(@PathVariable quizId: String, @Body command: QuizCreateCommand) = service.modifyQuiz(quizId, command)

    @Delete("{quizId}")
    fun removeQuiz(@PathVariable quizId: String) = service.removeQuiz(quizId)
}