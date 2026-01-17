package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates filter() and map() stream operations.
 * Filters students by name and CGPA criteria, then transforms results.
 */
public class StreamsFilterDemo {

    public static void main(String[] args) {
        List<Student> students = StudentUtils.getStudentList();

        // Filter 1: Names starting with "S"
        System.out.println("Students with names starting with 'S':");
        List<String> nameStartingWithS = students.stream()
                .filter(student -> student.getFirstName().startsWith("S"))
                .map(Student::getFirstName)
                .collect(Collectors.toList());
        System.out.println(nameStartingWithS);

        // Filter 2: Combined criteria - name starts with "S" AND CGPA > 9.0
        System.out.println("\nStudents with 'S' names and CGPA > 9.0:");
        List<String> topPerformersWithS = students.stream()
                .filter(student -> student.getFirstName().startsWith("S"))
                .filter(student -> student.getCgpa() > 9.0)
                .map(Student::getFirstName)
                .collect(Collectors.toList());
        System.out.println(topPerformersWithS);
    }
}
