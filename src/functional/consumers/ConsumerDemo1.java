package functional.consumers;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Demonstrates Consumer and BiConsumer with various operations.
 * Shows composition using andThen() and filtering using custom Consumers.
 */
public class ConsumerDemo1 {

    // Consumer: Print entire student object
    private static Consumer<Student> printStudent = student -> System.out.println(student);
    
    // Consumer: Print student hobbies
    private static Consumer<Student> printHobbies = student -> System.out.println(student.getHobbies());
    
    // Consumer: Print student name (first and last)
    private static Consumer<Student> printName =
        student -> System.out.println(student.getFirstName() + " " + student.getLastName());

    public static void main(String[] args) {
        // Simple Consumer demonstration
        Consumer<String> printMessage = message -> System.out.println("Message: " + message);
        printMessage.accept("Hello, World!");
        System.out.println();

        // BiConsumer demonstration
        BiConsumer<String, String> printGreeting =
            (greeting, name) -> System.out.println(greeting + ", " + name);
        printGreeting.accept("Hello", "Java 8");
        System.out.println();

        // Get student list and perform various operations
        List<Student> studentList = StudentUtils.getStudentList();

        System.out.println("\n--- All Students ---");
        printAllStudents(studentList);

        System.out.println("\n--- Student Names ---");
        printAllNames(studentList);

        System.out.println("\n--- Names and Hobbies (andThen) ---");
        printNamesWithHobbies(studentList);

        System.out.println("\n--- Names and Hobbies (CGPA > 8.0) ---");
        printNameAndHobbiesWithMinCgpa(studentList, 8.0);

        System.out.println("\n--- Names and Hobbies (CGPA > 7.0 AND has required hobbies) ---");
        List<String> requiredHobbies = Arrays.asList("swimming", "news", "Tennis");
        printNameAndHobbiesWithCriteria(studentList, 7.0, requiredHobbies);
    }

    /**
     * Prints all students.
     */
    private static void printAllStudents(List<Student> studentList) {
        studentList.forEach(printStudent);
    }

    /**
     * Prints all student names.
     */
    private static void printAllNames(List<Student> studentList) {
        studentList.forEach(printName);
    }

    /**
     * Prints student names followed by hobbies using Consumer composition.
     */
    private static void printNamesWithHobbies(List<Student> studentList) {
        studentList.forEach(printName.andThen(printHobbies));
    }

    /**
     * Prints names and hobbies for students with CGPA above the threshold.
     */
    private static void printNameAndHobbiesWithMinCgpa(List<Student> studentList, Double minCgpa) {
        studentList.stream()
            .filter(student -> student.getCgpa() > minCgpa)
            .forEach(printName.andThen(printHobbies));
    }

    /**
     * Prints names and hobbies for students meeting CGPA and hobbies criteria.
     */
    private static void printNameAndHobbiesWithCriteria(
            List<Student> studentList, Double minCgpa, List<String> requiredHobbies) {
        studentList.stream()
            .filter(student -> student.getCgpa() > minCgpa && requiredHobbies.containsAll(student.getHobbies()))
            .forEach(printName.andThen(printHobbies));
    }
}