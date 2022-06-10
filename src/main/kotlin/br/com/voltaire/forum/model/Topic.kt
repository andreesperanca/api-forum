package br.com.voltaire.forum.model
import java.time.LocalDateTime

data class Topic (
    var id: Long? = null,
    val title : String,
    val message : String,
    val createDate : LocalDateTime = LocalDateTime.now(),
    val curse : Curse,
    val author : User,
    val status : TopicStatus = TopicStatus.NOT_RESOLVED,
    val answers : List<Answers> = ArrayList()
)
