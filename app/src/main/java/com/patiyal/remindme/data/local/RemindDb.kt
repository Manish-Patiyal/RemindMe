package com.patiyal.remindme.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.patiyal.remindme.data.local.dao.TaskDao
import com.patiyal.remindme.data.model.Task


@Database(entities = [Task::class], version = 1)
abstract class RemindDb : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var instance: RemindDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            RemindDb::class.java, "todo-list.db"
        )
            .build()
    }
}