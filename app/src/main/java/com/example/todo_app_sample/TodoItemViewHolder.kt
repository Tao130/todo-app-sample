package com.example.todo_app_sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app_sample.databinding.TodoItemViewBinding

class TodoItemViewHolder(private val binding: TodoItemViewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Todo, clickListener: TodoClickListener) {
        binding.todo = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }
    companion object {
        fun from(parent: ViewGroup): TodoItemViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = TodoItemViewBinding.inflate(layoutInflater, parent, false)
            return TodoItemViewHolder(
                binding
            )
        }
    }
}