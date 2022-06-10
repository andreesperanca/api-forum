package br.com.voltaire.forum.controller

import br.com.voltaire.forum.dto.NewTopicForm
import br.com.voltaire.forum.dto.TopicView
import br.com.voltaire.forum.dto.UpdateTopicForm
import br.com.voltaire.forum.model.Topic
import br.com.voltaire.forum.services.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {


    @GetMapping
    fun listTopics(): List<TopicView> = service.list()

    @GetMapping("/{id}")
    fun getById(@PathVariable id : Long) : TopicView = service.getById(id)

    @PostMapping
    fun createTopic (
        @RequestBody @Valid topic: NewTopicForm,
        uriBuilder : UriComponentsBuilder)
        : ResponseEntity<TopicView> {
        val topicView = service.createTopic(topic)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun updateTopics (@RequestBody @Valid topicForm : UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.updateTopics(topicForm)
        return ResponseEntity.ok(topicView)

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic (@PathVariable id : Long) = service.deleteTopic(id)

}