package cn.ddd.examination

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info

@OpenAPIDefinition(
    info = Info(
        title = "DDD Homework",
        version = "0.2"
    )
)
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut
            .build()
            .packages("cn.ddd.examination")
            .mainClass(javaClass)
            .start()
    }
}