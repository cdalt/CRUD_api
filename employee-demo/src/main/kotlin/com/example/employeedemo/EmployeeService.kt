package com.example.employeedemo

import com.example.employeedemo.models.Employee

interface EmployeeService {
    fun findByName(name: String): Employee?
    fun findAllEmployees(): List<Employee>
}