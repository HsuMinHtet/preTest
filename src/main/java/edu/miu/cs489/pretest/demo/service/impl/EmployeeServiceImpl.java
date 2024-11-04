package edu.miu.cs489.pretest.demo.service.impl;

import edu.miu.cs489.pretest.demo.model.Employee;
import edu.miu.cs489.pretest.demo.repository.EmployeeRepository;
import edu.miu.cs489.pretest.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> addEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return Optional.of(savedEmployee);
    }

    @Override
    public Optional<Employee> updateEmployee(Employee employee) {
        Optional<Employee> foundEmployee = employeeRepository.findById(employee.getId());
        foundEmployee.ifPresent(employee1 -> {
            employeeRepository.save(employee);
        });
        return foundEmployee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        foundEmployee.ifPresent(employee -> {
            employeeRepository.delete(employee);
        });
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAllByOrderBySalaryAscLastNameDesc();
        return employees;
    }
}
