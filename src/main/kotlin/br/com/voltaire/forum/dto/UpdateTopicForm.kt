package br.com.voltaire.forum.dto

data class UpdateTopicForm(

//    @field:NotBlank
    val id : Long,
//    @field:NotEmpty
//    @field:Size(min = 5, max = 100)
    val title : String,
//    @field:NotEmpty
    val message : String
)
