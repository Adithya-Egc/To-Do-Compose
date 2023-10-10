package com.example.to_do_compose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_do_compose.data.models.TaskEntity
import com.example.to_do_compose.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val toDoRepository: ToDoRepository) :
    ViewModel() {


    private val _allTasks: MutableStateFlow<List<TaskEntity>> = MutableStateFlow(emptyList())
    val allTasks: StateFlow<List<TaskEntity>> = _allTasks


    fun getAllTasks() {
        viewModelScope.launch {
            toDoRepository.getAllTasks.collect {
                _allTasks.value = it

            }
        }
    }
}