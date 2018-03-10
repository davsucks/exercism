class Raindrops {
    companion object {
        fun convert(input: Int): String {
            var thing = ""
            (1..input).forEach {
                if (input % it == 0) {
                    when(it) {
                        3 -> thing += "Pling"
                        5 -> thing += "Plang"
                        7 -> thing += "Plong"
                    }
                }
            }
            return if (thing == "") input.toString() else thing
        }
    }
}
