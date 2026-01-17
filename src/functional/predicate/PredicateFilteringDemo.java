package functional.predicate;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Demonstrates Predicate usage with logical operations.
 * Shows and, or, negate operations for combining predicates.
 */
public class PredicateFilteringDemo {

    // Integer predicates
    private static final Predicate<Integer> isEven = num -> num % 2 == 0;
    private static final Predicate<Integer> isDivisibleBy5 = num -> num % 5 == 0;

    // Student predicates
    private static final Predicate<Student> hasMinimuCgpa = student -> student.getCgpa() > 7.0;
    private static final List<String> REQUIRED_HOBBIES = Arrays.asList("swimming", "news", "Tennis");
    private static final Predicate<Student> hasRequiredHobbies =
        student -> student.getHobbies() != null && REQUIRED_HOBBIES.containsAll(student.getHobbies());

    public static void main(String[] args) {
        // Test integer predicates
        System.out.println("Integer Predicate Tests:");
        System.out.println("10 is even: " + isEven.test(10));
        System.out.println();

        // AND operation
        System.out.println("12 is divisible by 5 AND even: " +
            isDivisibleBy5.and(isEven).test(12));
        System.out.println("10 is divisible by 5 AND even: " +
            isDivisibleBy5.and(isEven).test(10));
        System.out.println();

        // OR operation
        System.out.println("12 is divisible by 5 OR even: " +
            isDivisibleBy5.or(isEven).test(12));
        System.out.println();

        // NEGATE operation
        System.out.println("NOT (12 is divisible by 5 OR even): " +
            isDivisibleBy5.or(isEven).negate().test(12));
        System.out.println();

        // Student filtering
        System.out.println("\nStudent Predicate Tests:");
        System.out.println("Students with CGPA >= 7.0 and required hobbies:");
        List<Student> studentList = StudentUtils.getStudentList();
        studentList.stream()
            .filter(hasMinimuCgpa.and(hasRequiredHobbies))
            .forEach(student -> System.out.println("  " + student.getFirstName() + " " +
                student.getLastName() + " (CGPA: " + student.getCgpa() + ")"));
    }
}
