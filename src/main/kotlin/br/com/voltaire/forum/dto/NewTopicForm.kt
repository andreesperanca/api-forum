package br.com.voltaire.forum.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty


data class NewTopicForm(

//    @field:NotEmpty
    val title: String,
//    @field:NotEmpty
    val message: String,
//    @field:NotEmpty
    val idCurse : Long,
//    @field:NotEmpty
    val idAuthor : Long
)
