import java.time.LocalDate
import java.time.LocalDateTime
import java.time.chrono.ChronoPeriod
import kotlin.math.*

class Gigasecond {
    val date: LocalDateTime
    constructor(ld: LocalDate) : this(ld.atStartOfDay())

    constructor(ldt: LocalDateTime) {
        this.date = ldt.plusSeconds(seconds)
    }

    companion object {
        private val seconds: Long = 1_000_000_000
    }
}