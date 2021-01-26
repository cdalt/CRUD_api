package com.example.employeedemo

import com.example.employeedemo.models.Employee
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository: CrudRepository<Employee, Long> {
fun findAllEmployees
}