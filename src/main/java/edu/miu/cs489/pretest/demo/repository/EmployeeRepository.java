package edu.miu.cs489.pretest.demo.repository;

import edu.miu.cs489.pretest.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByOrderBySalaryAscLastNameDesc();

}
