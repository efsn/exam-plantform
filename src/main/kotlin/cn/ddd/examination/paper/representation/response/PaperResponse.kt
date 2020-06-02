package cn.ddd.examination.paper.representation.response

import cn.ddd.examination.paper.domain.model.entity.Paper
import java.time.LocalDateTime

data class PaperResponse(
    val paperId: String,
    val quizzes: List<Paper.Quiz>,
    val teacherId: String,
    val createTime: LocalDateTime
)

fun Paper.toResponse() = PaperResponse(paperId?.id.orEmpty(), quizzes, teacherId, createTime)