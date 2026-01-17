package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

/**
 * Demonstrates short-circuit terminal operations: allMatch, anyMatch, noneMatch, findFirst, findAny.
 */
public class StreamsMatchDemo {

    public static void main(String[] args) {
        // allMatch: true if all elements satisfy the predicate
        System.out.println("===== Match Operations (CGPA > 9) =====");
        boolean allMatch = StudentUtils.getStudentList().stream()
                .allMatch(student -> student.getCgpa() > 9);
        System.out.println("All students have CGPA > 9: " + allMatch);

        // noneMatch: true if no elements satisfy the predicate
        boolean noneMatch = StudentUtils.getStudentList().stream()
                .noneMatch(student -> student.getCgpa() > 9);
        System.out.println("No students have CGPA > 9: " + noneMatch);

        // anyMatch: true if any element satisfies the predicate
        boolean anyMatch = StudentUtils.getStudentList().stream()
                .anyMatch(student -> student.getCgpa() > 9);
        System.out.println("Any student has CGPA > 9: " + anyMatch);

        // findFirst: returns Optional containing first matching element
        System.out.println("\n===== Finding first student with CGPA > 9 =====");
        String firstStudent = StudentUtils.getStudentList().stream()
                .filter(student -> student.getCgpa() > 9)
                .findFirst()
                .map(Student::getFirstName)
                .get();
        System.out.println("First matching student: " + firstStudent);

        // findAny: returns Optional containing any matching element (may differ in parallel streams)
        System.out.println("\n===== Finding any student with CGPA > 9 =====");
        String anyStudent = StudentUtils.getStudentList().stream()
                .filter(student -> student.getCgpa() > 9)
                .findAny()
                .map(Student::getFirstName)
                .get();
        System.out.println("Any matching student: " + anyStudent);
    }
}
