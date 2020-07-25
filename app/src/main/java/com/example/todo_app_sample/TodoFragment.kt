package com.example.todo_app_sample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_app_sample.databinding.FragmentTodoBinding
import kotlinx.android.synthetic.main.fragment_todo.*


class TodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTodoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_todo, container, false
        )

        // requireNotNull:Throws an IllegalArgumentException if the value is null. Otherwise returns the not null value.
        val application = requireNotNull(this.activity).application
        val dataSource = AppDatabase.getInstance(application).todoDao

        val viewModelFactory = TodoViewModelFactory(dataSource, application)
        val todoViewModel = ViewModelProvider(this, viewModelFactory).get(TodoViewModel::class.java)
        binding.lifecycleOwner = this
        binding.todoViewModel = todoViewModel

        val clickListener = TodoClickListener(
            { todo ->
                todoViewModel.deleteTodo(todo)
                Toast.makeText(
                    context,
                    "${todo.todoName}を削除しました",
                    Toast.LENGTH_LONG
                ).show()
            },
            { todoViewModel.updateTodo(it) }
        )
        val adapter = TodoListAdapter(clickListener)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter

        // todoListの監視
        todoViewModel.todoList.observe(
            viewLifecycleOwner, Observer {
                it?.let {
                    adapter.setTodoList(it)
                }
            })

        binding.insertButton.setOnClickListener {
            val newTodo = Todo(todoName = insert_todo_name.text.toString())
            todoViewModel.insertTodo(newTodo)
            insert_todo_name.text.clear()
        }

        return binding.root
    }
}