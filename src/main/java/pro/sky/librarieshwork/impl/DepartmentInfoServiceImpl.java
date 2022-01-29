package pro.sky.librarieshwork.impl;

import org.springframework.stereotype.Service;
import pro.sky.librarieshwork.data.Employee;
import pro.sky.librarieshwork.exceptions.NoEmployeeFoundException;
import pro.sky.librarieshwork.service.DepartmentInfoService;
import pro.sky.librarieshwork.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentInfoServiceImpl implements DepartmentInfoService {

    private final EmployeeService employeeService;

    public DepartmentInfoServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment(department))
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new NoEmployeeFoundException());
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment(department))
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new NoEmployeeFoundException());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartment(int department) {
        return (Map<Integer, List<Employee>>) employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartment(department))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment()));
    }
}
