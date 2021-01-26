package com.example.employeedemo.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "employee")

data class Employee (
    @Id
    val id: Long = -1,
    val name: String,
    val salary: Int,
    val married: Boolean,
    val sex: String?)

