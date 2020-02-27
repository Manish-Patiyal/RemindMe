package com.patiyal.remindme.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "task")
data class Task(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "task_name") val name: String?,
    @ColumnInfo(name = "task_description") val description: String?,
    @ColumnInfo(name = "exp_date") val expDate: Date,
    @ColumnInfo(name = "start_date") val startDate: Date
)