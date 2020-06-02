package cn.ddd.examination.quiz.domain.model.entity

import cn.ddd.examination.common.domain.model.Entity
import cn.ddd.examination.quiz.domain.model.vo.QuizBankId
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import cn.ddd.examination.quiz.domain.model.entity.Quiz.Type.BLANK

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