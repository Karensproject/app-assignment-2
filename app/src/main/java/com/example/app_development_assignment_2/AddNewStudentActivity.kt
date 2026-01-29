package com.example.app_development_assignment_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_development_assignment_2.model.Model
import com.example.app_development_assignment_2.model.Student

class AddNewStudentActivity : AppCompatActivity() {
    private lateinit var studentNameEditText: EditText
    private lateinit var studentIdEditText: EditText
    private lateinit var studentPhoneEditText: EditText
    private lateinit var studentAddressEditText: EditText
    private lateinit var studentIsSelectedCheckBox: CheckBox
    private lateinit var saveStudentButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_new_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        studentIdEditText = findViewById(R.id.add_student_activity_id_edit_text)
        studentNameEditText = findViewById(R.id.add_student_activity_name_edit_text)
        studentPhoneEditText = findViewById(R.id.add_student_activity_phone_edit_text)
        studentAddressEditText = findViewById(R.id.add_student_activity_address_edit_text)
        studentIsSelectedCheckBox = findViewById(R.id.add_student_activity_checked_checkbox)
        saveStudentButton = findViewById(R.id.add_student_activity_save_button)
        cancelButton = findViewById(R.id.add_student_activity_cancel_button)
        saveStudentButton.setOnClickListener(::saveStudent)
        cancelButton.setOnClickListener(::cancel)
    }

    private fun saveStudent(view: View) {
        val student = Student(
            name = studentNameEditText.text.toString(),
            id = studentIdEditText.text.toString(),
            phone = studentPhoneEditText.text.toString(),
            address = studentAddressEditText.text.toString(),
            isSelected = studentIsSelectedCheckBox.isChecked
        )
        Model.shared.students.add(student)
        finish()
    }

    private fun cancel(view: View) {
        finish()
    }
}