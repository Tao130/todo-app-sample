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

    // カプセル化 MutableLiveDataをViewへ公開しないようにする
    private val _todoList = MutableLiveData<List<Todo>>()
    val todoList: LiveData<List<Todo>> = _todoList

    init {
        initializeTodoList()
    }

    private fun initializeTodoList() = viewModelScope.launch {
        _todoList.value = getTodoListFromDatabase().value
    }

    private suspend fun getTodoListFromDatabase(): LiveData<List<Todo>> {
        return withContext(Dispatchers.IO) {
            todoDao.getAllTodo()
        }
    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        todoDao.deleteTodo(todo)
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch {
        todoDao.updateTodo(todo)
    }

    fun insertTodo(todo: Todo) = viewModelScope.launch(Dispatchers.IO) {
        todoDao.insertTodo(todo)
    }
}