package cn.ddd.examination.paper.domain.exception

class PaperNotFoundException : Exception()
class IllegalQuizzesCountException(actual: Int) : IllegalArgumentException("TooManyQuizzesException: exception:5~20, actual:$actual")