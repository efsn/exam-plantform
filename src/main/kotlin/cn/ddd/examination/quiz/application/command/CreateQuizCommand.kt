package cn.ddd.examination.quiz.application.command

import cn.ddd.examination.quiz.domain.model.entity.Quiz
import cn.ddd.examination.quiz.domain.model.entity.Quiz.Type.Companion.of
import cn.ddd.examination.quiz.domain.model.vo.QuizBankId

data class CreateQuizCommand(
    val quizBankId: String,
    val type: String,
    val subject: String,
    val referenceAnswer: String,
    val teacherId: String
)

fun CreateQuizCommand.toEntity() = Quiz(
    quizBankId = QuizBankId(quizBankId),
    type = of(type),
    subject = subject,
    referenceAnswer = referenceAnswer,
    teacherId = teacherId
)