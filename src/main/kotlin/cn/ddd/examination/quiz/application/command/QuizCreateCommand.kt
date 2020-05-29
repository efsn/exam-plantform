package cn.ddd.examination.quiz.application.command

import cn.ddd.examination.quiz.domain.model.Quiz
import cn.ddd.examination.quiz.domain.model.Quiz.Type.Companion.of
import cn.ddd.examination.quiz.domain.model.QuizBankId

data class QuizCreateCommand(
    val quizBankId: String,
    val type: String,
    val subject: String,
    val referenceAnswer: String,
    val teacherId: String
)

fun QuizCreateCommand.toEntity() = Quiz(
    quizBankId = QuizBankId(quizBankId),
    type = of(type),
    subject = subject,
    referenceAnswer = referenceAnswer,
    teacherId = teacherId
)