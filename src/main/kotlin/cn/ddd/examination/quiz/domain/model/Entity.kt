package cn.ddd.examination.quiz.domain.model

import cn.ddd.examination.quiz.domain.model.Quiz.Type.BLANK

interface Entity<E>

data class Quiz(
    val quizBankId: QuizBankId,
    val id: QuizId? = null,
    val type: Type = BLANK,
    val subject: String,
    val referenceAnswer: String,
    val teacherId: String
) : Entity<Quiz> {

    enum class Type {
        BLANK,
        UNKNOWN;

        companion object {
            fun of(type: String) = values().firstOrNull { it.name == type } ?: UNKNOWN
        }
    }
}