package cn.ddd.examination.quiz.domain.model.vo

import cn.ddd.examination.common.domain.model.ValueObject

data class QuizId(
    val id: String
) : ValueObject<QuizId>