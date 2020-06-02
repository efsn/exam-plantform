package cn.ddd.examination.paper.domain.model.vo

import cn.ddd.examination.common.domain.model.ValueObject
import cn.ddd.examination.quiz.domain.model.vo.QuizId

data class Quiz(
    val quizId: QuizId,
    val score: Int
) : ValueObject<Quiz>