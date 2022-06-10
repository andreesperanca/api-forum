package br.com.voltaire.forum.model

import java.time.LocalDateTime

data class Answers(
    val id : Long,
    val message : String,
    val dateCreate : LocalDateTime = LocalDateTime.now(),
    val author : User,
    val topic : Topic,
    val solution : Boolean
)
