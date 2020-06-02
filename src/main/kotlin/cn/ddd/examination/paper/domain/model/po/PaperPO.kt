package cn.ddd.examination.paper.domain.model.po

import java.time.LocalDateTime

data class PaperPO(
    val paperId: String? = null,
    val quizzes: List<String>,
    val teacherId: String,
    val createTime: LocalDateTime
)

// TODO