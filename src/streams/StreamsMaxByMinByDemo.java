package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.*;

/**
 * Demonstrates maxBy and minBy collectors for finding extreme values by comparator.
 */
public class StreamsMaxByMinByDemo {

    public static void main(String[] args) {
        // Find student with maximum CGPA
        System.out.println("===== Finding student with maximum CGPA =====");
        Optional<Student> maxCgpaStudent = StudentUtils.getStudentList().stream()
                .collect(maxBy(Comparator.comparing(Student::getCgpa)));
        System.out.println("Student with highest CGPA: " + maxCgpaStudent.get().getFirstName() + 
                           " (CGPA: " + maxCgpaStudent.get().getCgpa() + ")");

        // Find student with minimum CGPA
        System.out.println("\n===== Finding student with minimum CGPA =====");
        Optional<Student> minCgpaStudent = StudentUtils.getStudentList().stream()
                .collect(minBy(Comparator.comparing(Student::getCgpa)));
        System.out.println("Student with lowest CGPA: " + minCgpaStudent.get().getFirstName() + 
                           " (CGPA: " + minCgpaStudent.get().getCgpa() + ")");
    }
}
