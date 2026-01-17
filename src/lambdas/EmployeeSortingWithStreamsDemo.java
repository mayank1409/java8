package lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Demonstrates stream operations and sorting using lambda expressions.
 * Shows sorting employees by salary in descending order using Comparator and streams.
 */
public class EmployeeSortingWithStreamsDemo {
    
    public static void main(String[] args) {
        // Create employee list
        List<Employee> employees = Arrays.asList(
            new Employee("John Doe", "john@example.com", 10000.0),
            new Employee("Paul Doe", "paul@example.com", 20000.0),
            new Employee("Shaun Doe", "shaun@example.com", 10000.0),
            new Employee("Chad Doe", "chad@example.com", 30000.0)
        );

        // Sort employees by salary in descending order using stream and method reference
        List<Employee> sortedByDescendingSalary = employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .collect(Collectors.toList());
        
        System.out.println("Employees sorted by salary (highest to lowest):");
        sortedByDescendingSalary.forEach(System.out::println);
    }
}

/**
 * Employee POJO with name, email, and salary information.
 */
class Employee {
    private String name;
    private String email;
    private Double salary;

    /**
     * Constructor to create an Employee with all details.
     */
    public Employee(String name, String email, Double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("salary=" + salary)
                .toString();
    }
}
