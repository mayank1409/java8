package lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee("John Doe", "John@doe.com", Double.valueOf(10000)),
                new Employee("Paul Doe", "Paul@doe.com", Double.valueOf(20000)),
                new Employee("Shaun Doe", "Shaun@doe.com", Double.valueOf(10000)),
                new Employee("Chad Doe", "Chad@doe.com", Double.valueOf(30000)));


        List<Employee> employeeList1 = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(employeeList1);
    }
}

class Employee {
    private String name;
    private String email;
    private Double salary;

    public Employee(String name, String email, Double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

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
        final StringBuilder sb = new StringBuilder();
        sb.append("name : ").append(name);
        return sb.toString();
    }
}
