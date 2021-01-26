package com.example.employeedemo

import com.example.employeedemo.models.Employee
import org.springframework.stereotype.Service

@Service
class DefaultEmployeeService: EmployeeService {
    override fun findByName(name: String): Employee? {
        TODO("Not yet implemented")
    }

    override fun findAllEmployees(): List<Employee> {
        return listOf(Employee(1,"Dalton", 30, true, null))
    }

}