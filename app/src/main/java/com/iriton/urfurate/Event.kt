package com.iriton.urfurate

import android.widget.ImageView
import java.io.Serializable

class Event : Serializable {
    val nameOfMeet: String;

    constructor(
        nameOfMeet: String,
        timeOfStart: String,
        timeOfEnd: String,
        background: Int,
        logo: Int,
        year: Int,
        month: Int,
        day: Int
    ) {
        this.nameOfMeet = nameOfMeet
        this.timeOfStart = timeOfStart
        this.timeOfEnd = timeOfEnd
        this.background = background
        this.logo = logo
        this.year = year
        this.month = month
        this.day = day
    }

    val timeOfStart: String
    val timeOfEnd: String
    val background: Int
    val logo: Int
    val year: Int
    val month: Int
    val day: Int
}