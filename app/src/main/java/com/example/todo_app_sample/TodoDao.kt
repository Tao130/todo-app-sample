package com.example.todo_app_sample

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Insert
    fun insertTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

    @Update
    fun updateTodo(todo: Todo)

    @Query("SELECT * FROM todo_table")
    fun getAllTodo(): List<Todo>

    @Query("DELETE FROM todo_table")
    fun deleteAllTodo()
}