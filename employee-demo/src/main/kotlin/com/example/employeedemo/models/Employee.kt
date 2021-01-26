package com.example.employeedemo.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "employees")
// plural for tables

data class Employee (
    @Id
    val id: Long = -1,
    val name: String = "",
    val salary: Int = -1,
    val married: Boolean = false,
    val sex: String? = null)