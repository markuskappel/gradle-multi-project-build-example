package org.example.placeholder

import org.springframework.web.client.RestClient
import org.springframework.web.client.body

// type internal to this module
internal class InternalTodo(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean,
)

// type visible to modules that depend on this module
class Todo(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean,
)

// type visible to modules that depend on this module
class SomeJsonApi(
    private val client: RestClient,
) {
    fun fetch(id: Int) =
        client
            .get()
            .uri("https://jsonplaceholder.typicode.com/todos/$id")
            .retrieve()
            .body<InternalTodo>()
            ?.let {
                Todo(
                    it.id,
                    it.userId,
                    it.title,
                    it.completed,
                )
            }
}
