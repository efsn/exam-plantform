package cn.ddd.examination.paper.representation.request

import cn.ddd.examination.paper.application.command.AssemblePaperCommand

data class PaperAssembleRequest(
    val teacherId: String,
    val quizzes: List<Quiz>
) {
    data class Quiz(
        val quizId: String,
        val score: Int
    )
}

fun PaperAssembleRequest.toCommand() = AssemblePaperCommand(teacherId, quizzes.map { it.toCommand() })
fun PaperAssembleRequest.Quiz.toCommand() = AssemblePaperCommand.Quiz(quizId, score)