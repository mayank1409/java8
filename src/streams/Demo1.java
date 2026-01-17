package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Demonstrates stream operations with filter and collect (toMap).
 * Creates a map of student first names to their hobbies based on CGPA criteria.
 */
public class Demo1 {

    public static void main(String[] args) {
        List<Student> students = StudentUtils.getStudentList();

        // Predicate: Students with CGPA > 8.0
        Predicate<Student> highCgpa = student -> student.getCgpa() > 8.0;

        // Stream: filter -> collect into Map
        Map<String, List<String>> studentNameToHobbies = students.stream()
                .filter(highCgpa)
                .collect(Collectors.toMap(Student::getFirstName, Student::getHobbies));
        
        System.out.println("Students with CGPA > 8.0 and their hobbies:");
        System.out.println(studentNameToHobbies);
    }
}
