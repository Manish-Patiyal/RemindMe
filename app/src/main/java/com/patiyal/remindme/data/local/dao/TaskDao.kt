package com.patiyal.remindme.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.patiyal.remindme.data.local.entity.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    suspend fun getAll(): List<Task>

    @Query("SELECT * FROM task WHERE uid IN (:taskIds)")
    suspend fun loadAllByIds(taskIds: IntArray): List<Task>

    @Insert
    suspend fun insertAll(vararg task: Task)

    @Delete
    suspend fun delete(task: Task)


    /*

    @Query(
        "SELECT * FROM task WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    suspend fun findByName(first: String, last: String): Task
*/

}
