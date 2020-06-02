package cn.ddd.examination.quiz.representation.request

import cn.ddd.examination.quiz.application.command.CreateQuizCommand

data class QuizCreateRequest(
    val quizBankId: String,
    val type: String,
    val subject: String,
    val referenceAnswer: String,
    val teacherId: String
)

fun QuizCreateRequest.toCommand() = CreateQuizCommand(
    quizBankId,
    type,
    subject,
    referenceAnswer,
    teacherId
)