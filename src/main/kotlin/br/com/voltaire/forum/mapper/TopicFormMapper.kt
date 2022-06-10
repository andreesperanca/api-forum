package br.com.voltaire.forum.mapper

import br.com.voltaire.forum.dto.NewTopicForm
import br.com.voltaire.forum.model.Topic
import br.com.voltaire.forum.services.CurseService
import br.com.voltaire.forum.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val curseService: CurseService,
    private val userService: UserService
) : Mapper<NewTopicForm, Topic> {

    override fun map(t: NewTopicForm): Topic =
        Topic(
            title = t.title,
            message = t.message,
            curse = curseService.findCurseById(t.idCurse),
            author = userService.findUserById(t.idAuthor)
        )
}
