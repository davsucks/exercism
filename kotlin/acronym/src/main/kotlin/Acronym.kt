class Acronym {
    companion object {
        fun generate(phrase: String): String = phrase.split(' ', '-').map {
                it.trim().capitalize().take(1)
            }.joinToString("")
    }
}