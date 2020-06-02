package cn.ddd.examination.paper.domain.model.entity

import cn.ddd.examination.common.domain.model.Entity
import cn.ddd.examination.common.domain.model.ValueObject
import cn.ddd.examination.paper.domain.exception.IllegalQuizzesCountException
import cn.ddd.examination.quiz.domain.model.vo.QuizId
import java.time.LocalDateTime
import java.time.LocalDateTime.now

data class Paper(
    val paperId: PaperId? = null,
    val quizzes: List<Quiz>,
    val teacherId: String,
    val createTime: LocalDateTime = now()
) : Entity<Paper> {

    init {
        validateQuizzes()
    }

    fun reassemble(teacherId: String, quizzes: List<Quiz>) = copy(teacherId = teacherId, quizzes = quizzes)

    private fun validateQuizzes() {
        if (quizzes.size > 20 || quizzes.size < 5) throw IllegalQuizzesCountException(quizzes.size)
    }

    data class Quiz(
        val quizId: QuizId,
        val score: Int
    )
}

data class PaperId(
    val id: String
) : ValueObject<PaperId>