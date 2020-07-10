package com.example.todo_app_sample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Insert
    fun insertTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo_table")
    fun getAllTodo(): List<Todo>

    @Query("DELETE FROM todo_table")
    fun deleteAllTodo()
}