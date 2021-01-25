package com.example.employeedemo.models

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "employee")
data class Employee (val name: String, val salary: Int, val married: Boolean, val sex: String?)

