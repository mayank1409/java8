package functional.supplier;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Demonstrates Supplier functional interface.
 * Shows how Suppliers can lazily provide objects without parameters.
 */
public class SupplierLazyEvaluationDemo {

    public static void main(String[] args) {
        // Supplier: Creates a predefined student
        Supplier<Student> singleStudentSupplier = () -> 
            new Student(
                "Mayank", "Madhav", "mayank.madhav@example.com",
                10.0, "MALE", 10,
                Arrays.asList("news", "cricket")
            );
        
        System.out.println("Single Student from Supplier:");
        Student student = singleStudentSupplier.get();
        System.out.println(student);
        System.out.println();

        // Supplier: Returns list of students
        Supplier<List<Student>> studentListSupplier = StudentUtils::getStudentList;
        
        System.out.println("All Students from Supplier:");
        List<Student> studentList = studentListSupplier.get();
        studentList.forEach(tempStudent -> 
            System.out.println("  - " + tempStudent.getFirstName() + " " + 
                tempStudent.getLastName() + " (CGPA: " + tempStudent.getCgpa() + ")"));
    }
}
