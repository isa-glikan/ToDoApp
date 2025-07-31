package com.example.todoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentAddTaskBinding
import com.example.todoapp.databinding.FragmentCurennetTodosBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.todoapp.adaptor.TodoAdaptor
import com.example.todoapp.model.TOdo
val todolist= mutableListOf<TOdo>()

class curennetTodos : Fragment() {
    private lateinit var binding: FragmentCurennetTodosBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentCurennetTodosBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addTaskBtn.setOnClickListener{
            findNavController(binding.addTaskBtn).navigate(R.id.action_curennetTodos_to_addTask1)
        }
        initRecViwe()
    }

    override fun onResume() {
        super.onResume()
        initRecViwe()
    }

    private fun initRecViwe(){
        val adapter = TodoAdaptor(todolist, requireContext())
        binding.recView.adapter = adapter
        binding.recView.layoutManager = LinearLayoutManager(requireContext())
    }


}