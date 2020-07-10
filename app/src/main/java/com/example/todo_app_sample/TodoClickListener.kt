package com.example.todo_app_sample

class TodoClickListener(
    val clickListenerDelete: (todo: Todo) -> Unit,
    val clickListenerUpdate: (todo: Todo) -> Unit

) {
    fun onClickDelete(todo: Todo) = clickListenerDelete
    fun onclickUpDate(todo: Todo) = clickListenerUpdate
}