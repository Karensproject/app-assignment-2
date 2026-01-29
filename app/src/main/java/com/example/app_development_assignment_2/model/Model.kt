package com.example.maya-and-karen-second-assignment.model

class Model private constructor() {
    val students = ArrayList<Student>()

    companion object {
        val shared = Model()
    }
}