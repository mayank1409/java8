package functional.function;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Demonstrates Function usage for transformations and compositions.
 * Shows basic Functions, andThen, compose, and practical student filtering examples.
 */
public class FunctionTransformationDemo {

    public static void main(String[] args) {
        // Basic integer squaring function
        Function<Integer, Integer> square = num -> num * num;
        System.out.println("Square of 10: " + square.apply(10));
        System.out.println();

        // String transformation functions
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> appendVersion = str -> str + "8";

        // Using andThen: first uppercase, then append version
        System.out.println("andThen (uppercase then append): " + 
            toUpperCase.andThen(appendVersion).apply("java"));

        // Using compose: first append version, then uppercase
        System.out.println("compose (append then uppercase): " + 
            toUpperCase.compose(appendVersion).apply("java"));
        System.out.println();

        // Student function demonstrations
        demonstrateStudentGradeMapping();
    }

    /**
     * Demonstrates Function usage with Student objects.
     * Filters students by CGPA and creates a grade mapping.
     */
    private static void demonstrateStudentGradeMapping() {
        // Predicate for high CGPA students
        Predicate<Student> highCgpaPredicate = student -> student.getCgpa() > 9.0;

        // Function: Convert student list to CGPA map for high performers
        Function<List<Student>, Map<String, Double>> createGradeMap = students -> {
            Map<String, Double> gradesMap = new HashMap<>();
            students.stream()
                .filter(highCgpaPredicate)
                .forEach(student -> gradesMap.put(
                    student.getFirstName() + " " + student.getLastName(),
                    student.getCgpa()
                ));
            return gradesMap;
        };

        System.out.println("Students with CGPA > 9.0:");
        Map<String, Double> result = createGradeMap.apply(StudentUtils.getStudentList());
        result.forEach((name, cgpa) -> System.out.println(name + ": " + cgpa));
    }
}
