package pro.sky.librarieshwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.librarieshwork.data.Employee;
import pro.sky.librarieshwork.service.DepartmentInfoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentInfoController {

    private final DepartmentInfoService departmentInfoService;

    public DepartmentInfoController(DepartmentInfoService departmentInfoService) {
        this.departmentInfoService = departmentInfoService;
    }

    @GetMapping(path = "/max-salary")
    Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") int department) {
        return departmentInfoService.getEmployeeWithMaxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    Employee getEmployeeWithMinSalary(@RequestParam("departmentId") int department) {
        return departmentInfoService.getEmployeeWithMinSalary(department);
    }

    @GetMapping(path = "/all")
    Map<Integer, List<Employee>> getEmployeesByDepartment(@RequestParam("departmentId") int department) {
        return departmentInfoService.getEmployeesByDepartment(department);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    Map<Integer, List<Employee>> getAllEmployees() {
        return departmentInfoService.getAllEmployees();
    }
}
