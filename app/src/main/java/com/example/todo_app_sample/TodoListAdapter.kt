package com.example.todo_app_sample

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(
    private val clickListener: TodoClickListener
) : RecyclerView.Adapter<TodoItemViewHolder>() {

    private var todoList = emptyList<Todo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        return TodoItemViewHolder.from(parent)
    }

    override fun getItemCount() = todoList.size

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val current = todoList[position]
        holder.bind(current, clickListener)
    }

    // internal修飾子：Module内ならどこからでも見える
    internal fun setTodoList(todoList: List<Todo>) {
        this.todoList = todoList
        // データセットの変更をオブザーバーに通知
        notifyDataSetChanged()
    }
}