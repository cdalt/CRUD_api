package com.example.employeedemo

import com.example.employeedemo.models.Employee
import org.aspectj.apache.bcel.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/employees")
class HtmlController(private val service: EmployeeService) {

    @Autowired
    lateinit var repository: EmployeeRepository

    @GetMapping(produces = ["application/json"])
    fun listEmployees(model: Model): Iterable<Employee> {
        return repository.findAll()
    }
    @GetMapping("/save")
    fun save(model: Model): String{
        repository.save(Employee(1,"Dalton", 30, true, null))
        return "done"
    }

    @GetMapping("/{employeeName}")
    fun getEmployeeByName(@PathVariable employeeName: String): Employee? {
        return service.findByName(employeeName)
    }
}
