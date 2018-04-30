import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Gigasecond(of: LocalDateTime) {
    private val gigasecond = Duration.of(1_000_000_000, ChronoUnit.SECONDS)
    val date: LocalDateTime

    init {
        this.date = of.plus(gigasecond)
    }

    constructor(of: LocalDate) : this(of.atStartOfDay())
}
