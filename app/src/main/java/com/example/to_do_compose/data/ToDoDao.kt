package com.example.to_do_compose.data

import androidx.room.*
import com.example.to_do_compose.data.models.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<TaskEntity>>


    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    fun getSelectedTask(taskId: Int): Flow<TaskEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(todoTaskEntity: TaskEntity)

    @Update
    suspend fun updateTask(todoTaskEntity: TaskEntity)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTask(todoTaskEntity: TaskEntity)


    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<TaskEntity>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<TaskEntity>>

}