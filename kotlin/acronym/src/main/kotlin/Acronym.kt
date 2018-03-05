class Acronym {
    companion object {
        fun generate(phrase: String): String = phrase
                .split(' ', '-')
                .joinToString("") {
                    it.trim().capitalize().take(1)
                }
    }
}