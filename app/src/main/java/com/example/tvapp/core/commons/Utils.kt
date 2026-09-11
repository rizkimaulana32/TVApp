package com.example.tvapp.core.commons


import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale

object Utils {
    fun String.formatPremiereDate(): String {
        val inputFormatter = DateTimeFormatter.ISO_LOCAL_DATE
        val outputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.forLanguageTag("en-US"))

        return try {
            LocalDate.parse(this, inputFormatter)
                .format(outputFormatter)
        } catch (e: DateTimeParseException) {
            this
        }
    }
}