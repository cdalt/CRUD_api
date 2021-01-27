package com.example.employeedemo

import com.example.employeedemo.models.Employee
import org.aspectj.apache.bcel.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class HtmlController(private val service: EmployeeService) {

    @GetMapping(produces = ["application/json"])
    fun listEmployees(): Iterable<Employee> {
        return service.findAllEmployees()
    }
    @PostMapping(consumes = ["application/json"])
    fun save(@RequestBody employeeRequest: Employee): String{
        return service.createEmployee(employeeRequest)
    }

    @GetMapping("{employeeId}")
    fun getEmployeeByName(@PathVariable employeeId: Long): Employee? {
        return service.findEmployeeById(employeeId)
    }
    @DeleteMapping("{employeeId}")
    fun deleteEmployeeById(@PathVariable employeeId: Long): Employee {
        return service.deleteEmployee(employeeId)
    }
    @PutMapping

}
