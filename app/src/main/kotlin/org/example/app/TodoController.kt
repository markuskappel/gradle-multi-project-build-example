package org.example.app

import org.example.placeholder.SomeJsonApi
import org.example.placeholder.Todo
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class TodoController(
    private val jsonApi: SomeJsonApi,
) {
    companion object {
        private val logger = LoggerFactory.getLogger(TodoController::class.java)
    }

    @GetMapping("/{id}")
    fun todo(
        @PathVariable id: Int,
    ): Todo? {
        logger.info("Fetching TODO with ID {}", id)
        // InternalTodo not available
        // val internalTodo = InternalTodo(1,2,"title", true)
        return jsonApi.fetch(id)
    }
}
