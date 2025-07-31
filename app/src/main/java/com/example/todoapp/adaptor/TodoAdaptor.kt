package com.example.todoapp.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.findFirstRoot
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.model.TOdo
class TodoAdaptor(var todoList:MutableList<TOdo>,var context: Context):
    RecyclerView.Adapter<TodoAdaptor.ViweHolder>() {

    inner class ViweHolder(itemViwe:View):RecyclerView.ViewHolder(itemViwe){
        var card= itemViwe.findViewById<CardView>(R.id.card)
        var titelTB= itemViwe.findViewById<TextView>(R.id.titelTxtBox)
        var descriptoinTB= itemViwe.findViewById<TextView>(R.id.discribTextBox)
        var dateText= itemViwe.findViewById<TextView>(R.id.dateTxt)
        var dateTB= itemViwe.findViewById<TextView>(R.id.dateTexBox)
        var timeText= itemViwe.findViewById<TextView>(R.id.timeTxt)
        var timeTB= itemViwe.findViewById<TextView>(R.id.timeTextBox)
        var isDonTB= itemViwe.findViewById<CheckBox>(R.id.isDoncheckBc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViweHolder {
        var view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_in_rec_viwe,parent,false)
        return ViweHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: ViweHolder, position: Int) {
        holder.apply {
            titelTB.text=todoList[position].titel
            descriptoinTB.text=todoList[position].description
            dateTB.text=todoList[position].date
            timeTB.text=todoList[position].time
            isDonTB.isChecked=todoList[position].isDON
        }
    }
}