import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(of: LocalDateTime) {
    constructor(of: LocalDate) : this(of.atStartOfDay())
    private val gigasecond: Long = 1_000_000_000L
    val date: LocalDateTime = of.plusSeconds(gigasecond)
}
