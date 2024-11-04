package edu.miu.cs489.pretest.demo;

import edu.miu.cs489.pretest.demo.model.Employee;
import edu.miu.cs489.pretest.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {
    private final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args->{
            Employee employee= new Employee(50000.00,"John","Doe");
            Employee employee1= new Employee(50000.00,"Jane","Dona");
            Employee employee2= new Employee(60000.00,"Alice","Smith");
            Employee employee3= new Employee(45000.00,"Bob","Brown");
            employeeService.addEmployee(employee);
            employeeService.addEmployee(employee1);
            employeeService.addEmployee(employee2);
            employeeService.addEmployee(employee3);
            System.out.println("All Employees");
            employeeService.getAllEmployee().forEach(System.out::println);
            System.out.println("Afer Update Employee Name: John to Hsu");
            employee.setFirstName("Hsu");
            employeeService.updateEmployee(employee);
            employeeService.getAllEmployee().forEach(System.out::println);

            System.out.println("Afer Delete Employee");
            employeeService.deleteEmployee(employee.getId());
            employeeService.getAllEmployee().forEach(System.out::println);



        };
    }
}
