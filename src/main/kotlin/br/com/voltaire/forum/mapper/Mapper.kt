package br.com.voltaire.forum.mapper

interface Mapper<T, U> {

    fun map (t: T) : U

}
