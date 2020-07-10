package com.example.todo_app_sample

class TodoClickListener(
    private val clickListenerDelete: (todo: Todo) -> Unit,
    private val clickListenerUpdate: (todo: Todo) -> Unit

) {
    fun onClickDelete(todo: Todo) = clickListenerDelete
    fun onclickUpDate(todo: Todo) = clickListenerUpdate
}