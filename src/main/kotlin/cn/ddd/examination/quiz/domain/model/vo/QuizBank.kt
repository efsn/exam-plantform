package cn.ddd.examination.quiz.domain.model.vo

import cn.ddd.examination.common.domain.model.ValueObject
import cn.ddd.examination.quiz.domain.model.entity.Quiz
import java.time.LocalDateTime

data class QuizBankId(
    val id: String
) : ValueObject<QuizBankId>

data class QuizBank(
    val id: QuizBankId,
    val desc: String,
    val updateTime: LocalDateTime,
    val quizzes: List<Quiz> = emptyList()
) : ValueObject<QuizBank>