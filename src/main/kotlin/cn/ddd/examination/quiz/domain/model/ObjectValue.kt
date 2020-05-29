package cn.ddd.examination.quiz.domain.model

import java.time.LocalDateTime

interface ObjectValue<V>

data class QuizId(
    val id: String
) : ObjectValue<QuizId>

data class QuizBankId(
    val id: String
) : ObjectValue<QuizBankId>

data class QuizBank(
    val id: QuizBankId,
    val desc: String,
    val updateTime: LocalDateTime,
    val quizzes: List<Quiz> = emptyList()
) : ObjectValue<QuizBank>