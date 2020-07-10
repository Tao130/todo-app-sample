package com.example.todo_app_sample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoViewModel(
    private val todoDao: TodoDao,
    application: Application) : AndroidViewModel(application) {

    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>>
        get() = _todoList

    init {
        initializeTodoList()
    }

    private fun initializeTodoList() = viewModelScope.launch {
        _todoList.value = getTodoListFromDatabase()
    }

    private suspend fun getTodoListFromDatabase(): List<Todo> {
        return withContext(Dispatchers.IO) {
            todoDao.getAllTodo()
        }
    }
}