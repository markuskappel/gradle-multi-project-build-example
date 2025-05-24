package org.example.app

import org.example.placeholder.SomeJsonApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class AppConfiguration {
    @Bean
    fun jsonApi() = SomeJsonApi(RestClient.create())
}
