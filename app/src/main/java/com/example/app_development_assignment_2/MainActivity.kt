package com.example.maya-and-karen-second-assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maya-and-karen-second-assignment.adapter.StudentsRecyclerAdapter
import com.example.maya-and-karen-second-assignment.model.Model
import com.example.maya-and-karen-second-assignment.model.Student


class MainActivity : AppCompatActivity() {
    private var students = ArrayList<Student>()
    private lateinit var studentsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        students = Model.shared.students
        studentsRecyclerView = findViewById(R.id.main_activity_students_recycler_view)
        studentsRecyclerView.setHasFixedSize(true)
        studentsRecyclerView.layoutManager = LinearLayoutManager(this)
        studentsRecyclerView.adapter = StudentsRecyclerAdapter(students)

        val addStudentButton = findViewById<Button>(R.id.main_activity_add_student_button)
        addStudentButton.setOnClickListener {
            startActivity(Intent(this, AddStudentActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        students = Model.shared.students
        (studentsRecyclerView.adapter as StudentsRecyclerAdapter).notifyDataSetChanged()
    }
}