package com.example.employeedemo

import com.example.employeedemo.models.Employee

interface EmployeeService {
    fun findEmployeeById(employeeId: Long): Employee?
    fun findAllEmployees(): Iterable<Employee>
    fun createEmployee(employee: Employee): String
    fun updateEmployeeSalary(employeeId: Long): Employee
    fun deleteEmployee(employeeId: Long): Employee
}