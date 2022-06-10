package br.com.voltaire.forum.services

import br.com.voltaire.forum.model.User
import org.springframework.stereotype.Service


@Service
class UserService (final var users : List<User>) {

    init {
        val user = User(
            id = 1,
            name = "Geovana",
            email = "geovana@gmail.com"
        )
       users = listOf(user)
    }

    fun findUserById(id : Long) = users.first { user -> user.id == id}
}
