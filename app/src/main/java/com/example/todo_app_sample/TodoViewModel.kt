package com.example.todo_app_sample

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class TodoViewModel(
    val todoDao: TodoDao,
    application: Application) : AndroidViewModel(application) {
}