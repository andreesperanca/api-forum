package br.com.voltaire.forum.services

import br.com.voltaire.forum.controller.TopicController
import br.com.voltaire.forum.dto.NewTopicForm
import br.com.voltaire.forum.dto.TopicView
import br.com.voltaire.forum.dto.UpdateTopicForm
import br.com.voltaire.forum.exception.NotFoundException
import br.com.voltaire.forum.mapper.TopicFormMapper
import br.com.voltaire.forum.mapper.TopicViewMapper
import br.com.voltaire.forum.model.Topic
import org.apache.commons.logging.Log
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic>,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado."

) {

    fun list(): List<TopicView> = topics.stream().map { t ->
        TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            createDate = t.createDate,
            status = t.status
        )
    }.collect(Collectors.toList())

    fun getById(id: Long): TopicView {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow {
            NotFoundException(notFoundMessage)
        }
        return topicViewMapper.map(topic)
    }


    fun createTopic(topicForm: NewTopicForm): TopicView {
        val topico = topicFormMapper.map(topicForm)
        topico.id = topics.size.toLong() + 1
        topics = topics.plus(topico)
        return topicViewMapper.map(topico)
    }

    fun updateTopics(form: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == form.id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }

        val updateTopic = Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            author = topic.author,
            curse = topic.curse,
            answers = topic.answers,
            status = topic.status,
            createDate = topic.createDate
        )
        topics = topics.minus(topic).plus(updateTopic)
        return topicViewMapper.map(updateTopic)
    }

    fun deleteTopic(id: Long) {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().orElseThrow {NotFoundException(notFoundMessage)}
       topics = topics.minus(topic)
    }
}
