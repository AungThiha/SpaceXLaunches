package aung.thiha.spacex.launches

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform