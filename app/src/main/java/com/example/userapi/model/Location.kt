package com.example.userapi.model

data class Location(
    val street: Street? = null,
    val city : String? = null,
    val state : String? = null,
    val country : String? = null,
    val postcode : String? = null,
    val coordinates: Coordinates? = null,
    val timeZone: TimeZone? = null
)
