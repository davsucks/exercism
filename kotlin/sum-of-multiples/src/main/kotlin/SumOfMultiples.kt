object SumOfMultiples {
    fun sum(multiples: Set<Int>, limit: Int): Int {
        return (1 until limit).filter { x -> multiples.any { y -> x % y == 0 } }.sum()
    }
}
