package com.example.maya-and-karen-second-assignment.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maya-and-karen-second-assignment.R
import com.example.maya-and-karen-second-assignment.StudentDetailsActivity
import com.example.maya-and-karen-second-assignment.model.Student

class StudentsRecyclerAdapter(private val students: ArrayList<Student>) : RecyclerView.Adapter<StudentsViewHolder>() {
    override fun getItemCount(): Int = students.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val inflation = LayoutInflater.from(parent.context)
        val view = inflation.inflate(R.layout.student_list_row, parent, false)

        return StudentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        holder.bind(students[position], position)
        val student = students[position]

        holder.itemView.apply {
            setOnClickListener {
                val context = it.context

                val intent = Intent(context, StudentDetailsActivity::class.java).apply {
                    putExtra("studentPosition", position)
                }

                context.startActivity(intent)
            }
        }
    }
}