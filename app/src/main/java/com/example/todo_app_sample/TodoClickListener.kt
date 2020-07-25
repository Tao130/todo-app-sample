package com.example.todo_app_sample

class TodoClickListener(
    private val clickListenerDelete: (todo: Todo) -> Unit,
    private val clickListenerUpdate: (todo: Todo) -> Unit

) {
    fun onClickDelete(todo: Todo) = clickListenerDelete(todo)
    fun onclickUpDate(todo: Todo) = clickListenerUpdate(todo)
}