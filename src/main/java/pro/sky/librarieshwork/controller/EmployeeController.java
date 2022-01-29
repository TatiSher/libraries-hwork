package pro.sky.librarieshwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.librarieshwork.data.Employee;
import pro.sky.librarieshwork.impl.EmployeeServiceImpl;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                      @RequestParam("departmentId") int department, @RequestParam("salary") int salary) {
        employeeService.add(firstName, lastName, department, salary);
        return "Сотрудник " + firstName + " " + lastName + ", " + department + ", " + salary + " " + " успешно создан.";
    }


    @GetMapping(path = "/remove")
    public String remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.remove(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " успешно удалён.";
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.remove(firstName, lastName);
        return "Сотрудник: " + firstName + " " + lastName;
    }

    @GetMapping(path = "/employees")
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

}
