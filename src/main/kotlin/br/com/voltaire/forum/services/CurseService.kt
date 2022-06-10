package br.com.voltaire.forum.services

import br.com.voltaire.forum.model.Curse
import org.springframework.stereotype.Service


@Service
class CurseService (final var cursos : List<Curse>) {

    init {
        val curso = Curse(
            id = 1,
            name = "Kotlin",
            category = "Programação"
        )
        cursos = listOf<Curse>(curso)
    }

    fun findCurseById(id : Long) = cursos.first { curse -> curse.id == id}


}
