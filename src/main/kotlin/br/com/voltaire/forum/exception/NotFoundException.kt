package br.com.voltaire.forum.exception

class NotFoundException(message : String? = "Nada foi encontrado.") : RuntimeException(message) {
}