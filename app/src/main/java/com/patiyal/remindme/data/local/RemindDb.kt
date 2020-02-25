package com.patiyal.remindme.data.local

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.RoomDatabase
import com.patiyal.remindme.data.local.dao.TaskDao
import com.patiyal.remindme.data.model.Task


@Database(entities = [Task::class], version = 1)
abstract class RemindDb : RoomDatabase() {
    abstract fun taskDao(): TaskDao


    private var sInstance: RemindDb? = null

    @VisibleForTesting
    val DATABASE_NAME = "basic-sample-db"


    private val mIsDatabaseCreated =
        MutableLiveData<Boolean>()


    /**
     * Check whether the database already exists and expose it via [.getDatabaseCreated]
     */
    open fun updateDatabaseCreated(context: Context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated()
        }
    }

    open fun setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true)
    }
}