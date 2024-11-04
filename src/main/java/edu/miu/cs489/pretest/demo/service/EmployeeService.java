package edu.miu.cs489.pretest.demo.service;

import edu.miu.cs489.pretest.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface EmployeeService {
    Optional<Employee> addEmployee(Employee employee);
    Optional<Employee> updateEmployee(Employee employee);
    void deleteEmployee(Integer id);
    List<Employee> getAllEmployee();

}
