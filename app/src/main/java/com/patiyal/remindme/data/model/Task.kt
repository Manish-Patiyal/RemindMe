package com.patiyal.remindme.data.model

import java.util.*

data class Task(
    val id: Int,
    var name: String,
    var description: String,
    val expDate: Date,
    val startDate: Date
)