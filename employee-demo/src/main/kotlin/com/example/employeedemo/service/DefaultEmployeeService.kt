package com.example.employeedemo.service

import com.example.employeedemo.EmployeeRepository
import com.example.employeedemo.models.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultEmployeeService: EmployeeService {

    @Autowired
    lateinit var repository: EmployeeRepository

    override fun findEmployeeById(employeeId: Long): Employee? {
        val repositoryEmployee = repository.findById(employeeId)
        if (repositoryEmployee.isPresent){
            return repositoryEmployee.get()
        } else {
            throw Exception("Employee not found")
        }
    }

    override fun findAllEmployees(): Iterable<Employee> {
        return repository.findAll()
    }

    override fun createEmployee(employee: Employee): String {
        repository.save(
            Employee(
                employee.id,
                employee.name,
                employee.salary,
                employee.married,
                employee.sex,
                employee.email
            )
        )

        return "done"
    }

    override fun updateEmployee(employee: Employee): Employee {
        return repository.save(Employee(
            employee.id,
            employee.name,
            employee.salary,
            employee.married,
            employee.sex,
            employee.email
        ))
    }

    override fun deleteEmployee(employeeId: Long): String {
        repository.deleteById(employeeId)
        return "deleted"
    }
}