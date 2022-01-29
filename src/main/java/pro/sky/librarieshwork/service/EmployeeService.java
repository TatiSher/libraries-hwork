package pro.sky.librarieshwork.service;

import pro.sky.librarieshwork.data.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int department, int salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getEmployees();

}
