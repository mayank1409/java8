package streams;

import functional.utils.StudentUtils;

import static java.util.stream.Collectors.counting;

/**
 * Demonstrates counting collector operations.
 * Counts total students and students meeting specific criteria.
 */
public class StreamCountingDemo {

    public static void main(String[] args) {
        // Count all students
        Long totalStudents = StudentUtils.getStudentList().stream()
                .collect(counting());
        System.out.println("Total students: " + totalStudents);

        // Count students with CGPA > 8.0
        Long highCgpaStudents = StudentUtils.getStudentList().stream()
                .filter(s -> s.getCgpa() > 8)
                .collect(counting());
        System.out.println("Students with CGPA > 8.0: " + highCgpaStudents);
    }
}
