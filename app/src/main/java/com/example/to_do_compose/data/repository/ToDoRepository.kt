package com.example.to_do_compose.data.repository

import com.example.to_do_compose.data.ToDoDao
import com.example.to_do_compose.data.models.TaskEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    val getAllTasks: Flow<List<TaskEntity>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<TaskEntity>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<TaskEntity>> = toDoDao.sortByHighPriority()

    suspend fun addTask(taskEntity: TaskEntity) {
        toDoDao.addTask(taskEntity)
    }

    suspend fun updateTask(taskEntity: TaskEntity) {
        toDoDao.updateTask(taskEntity)
    }

    suspend fun deleteAllTasks() {
        toDoDao.deleteAllTask()
    }

    suspend fun deleteSingleTask(taskEntity: TaskEntity) {
        toDoDao.deleteTask(taskEntity)
    }

    fun searchDatabase(searchQuery: String): Flow<List<TaskEntity>> {
        return toDoDao.searchDatabase(searchQuery)
    }
}