import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Gigasecond(of: LocalDateTime) {
    constructor(of: LocalDate) : this(of.atStartOfDay())
    private val gigasecond = Duration.of(1_000_000_000, ChronoUnit.SECONDS)
    val date: LocalDateTime = of.plus(gigasecond)
}
