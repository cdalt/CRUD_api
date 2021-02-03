package com.example.employeedemo

import com.example.employeedemo.models.Employee
import com.example.employeedemo.service.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/employees")
class HtmlController(private val service: EmployeeService) {

    val regex = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+\$".toRegex()

    @GetMapping(produces = ["application/json"])
    fun listEmployees(): Iterable<Employee> {
        return service.findAllEmployees()
    }
    @PostMapping(consumes = ["application/json"])
    fun save(@RequestBody employeeRequest: Employee): String {
        return if (regex.matchEntire(employeeRequest.email) != null){
            service.createEmployee(employeeRequest)
        } else {
            "Not a valid Email"
        }
    }

    @GetMapping("/{employeeId}")
    fun getEmployeeById(@PathVariable employeeId: Long): Employee? {
        return service.findEmployeeById(employeeId)
        val employee: Employee? = null
        try {
            employee = service.findEmployeeById(employeeId)
        } catch (e:Exception){
            println(e)
        }
        return employee
    }
    @DeleteMapping("/{employeeId}")
    fun deleteEmployeeById(@PathVariable employeeId: Long): String {
        return service.deleteEmployee(employeeId)
    }
    @PutMapping(consumes = ["application/json"])
    fun updateEmployee(@RequestBody employeeRequest: Employee): String {
        return if (regex.matchEntire(employeeRequest.email) != null) {
            service.updateEmployee(employeeRequest)
            "Saved Employee"
        } else {
            "Employee did not update"
        }
    }
}
