package cn.ddd.examination

import io.micronaut.runtime.Micronaut

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut
            .build()
            .packages("cn.ddd.examination¬")
            .mainClass(javaClass)
            .start()
    }
}