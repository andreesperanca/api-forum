package br.com.voltaire.forum.mapper

import br.com.voltaire.forum.dto.TopicView
import br.com.voltaire.forum.model.Topic
import org.springframework.stereotype.Component


@Component
class TopicViewMapper : Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView =
        TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            createDate = t.createDate,
            status = t.status
        )
}