package br.com.voltaire.forum.dto

import br.com.voltaire.forum.model.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id :Long?,
    val title : String,
    val message : String,
    val status : TopicStatus,
    val createDate : LocalDateTime
)
