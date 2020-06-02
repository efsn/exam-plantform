package cn.ddd.examination.quiz.representation.response

import cn.ddd.examination.quiz.domain.model.entity.Quiz

data class QuizResponse(
    val quizBankId: String,
    val quizId: String,
    val type: String,
    val subject: String,
    val referenceAnswer: String,
    val teacherId: String
)

fun Quiz.toResponse() = QuizResponse(
    quizBankId.id,
    id?.id.orEmpty(),
    type.name,
    subject,
    referenceAnswer,
    teacherId
)