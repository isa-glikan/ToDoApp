package com.example.todoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.Pair
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentAddTaskBinding
import com.example.todoapp.model.TOdo
import com.example.todoapp.utils.Picker
import com.example.todoapp.utils.fullDate
import com.example.todoapp.utils.hour
import com.example.todoapp.utils.minute

/**
 * A simple [Fragment] subclass.
 * Use the [AddTask.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddTask : Fragment() {

   private lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentAddTaskBinding.inflate(inflater, container, false)
        return binding!!.root

        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dateTextInput.setOnClickListener{
                Picker(parentFragmentManager,binding.dateTextInput)
        }

        binding.addTaskBTN.setOnClickListener {
            val newTodo= TOdo(binding.titelEditeTXT.editableText.toString(),
                binding.discriptonEditText.editText?.text.toString(),"$hour:$minute", fullDate,false
            )
            todolist.add(newTodo)
            Navigation.findNavController(binding.addTaskBTN).navigate(R.id.action_addTask1_to_curennetTodos)
        }
    }

}