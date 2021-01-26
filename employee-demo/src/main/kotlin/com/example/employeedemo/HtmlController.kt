package com.example.employeedemo

import com.example.employeedemo.models.Employee
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
class HtmlController(private val service: EmployeeService) {

    @GetMapping(produces = ["application/json"])
    fun listEmployees(model: Model): List<Employee> {
        return service.findAllEmployees()
    }

    @GetMapping("/{employeeName}")
    fun getEmployeeByName(@PathVariable employeeName: String): Employee? {
        return service.findByName(employeeName)
    }
}
