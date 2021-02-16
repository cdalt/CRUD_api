package com.example.employeedemo

import com.example.employeedemo.models.Employee
//import com.example.employeedemo.models.Employer
import org.springframework.data.repository.CrudRepository

interface EmployeeRepository: CrudRepository<Employee, Long> {
//    fun findAllEmployees(): List<Employee>
}
//interface EmployerRepository: CrudRepository<Employer, Long> {
////    fun findAllEmployees(): List<Employee>
//}