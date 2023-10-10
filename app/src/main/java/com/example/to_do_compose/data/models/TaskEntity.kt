package com.example.to_do_compose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.to_do_compose.data.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
