package cn.ddd.examination.paper.application.command

import cn.ddd.examination.paper.domain.model.entity.Paper
import cn.ddd.examination.quiz.domain.model.vo.QuizId

data class AssemblePaperCommand(
    val teacherId: String,
    val quizzes: List<Quiz>
) {
    data class Quiz(
        val quizId: String,
        val score: Int
    )
}

fun AssemblePaperCommand.toEntity() =
    Paper(
        quizzes = quizzes.map { it.toEntity() },
        teacherId = teacherId
    )

fun AssemblePaperCommand.Quiz.toEntity() = Paper.Quiz(QuizId(quizId), score)