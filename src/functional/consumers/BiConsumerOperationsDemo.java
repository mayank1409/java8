package functional.consumers;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Demonstrates BiConsumer usage with string and numeric operations.
 * Shows composition using andThen() and practical examples with Students.
 */
public class BiConsumerOperationsDemo {
    
    public static void main(String[] args) {
        // Simple string BiConsumer
        BiConsumer<String, String> printPair = (a, b) -> System.out.println(a + " : " + b);
        printPair.accept("Key", "Value");
        System.out.println();

        // Arithmetic BiConsumer operations
        BiConsumer<Integer, Integer> multiply = (a, b) ->
            System.out.println("Multiplication: " + a + " × " + b + " = " + (a * b));
        
        BiConsumer<Integer, Integer> divide = (a, b) ->
            System.out.println("Division: " + a + " ÷ " + b + " = " + (a / b));
        
        System.out.println("Using andThen() to compose operations:");
        multiply.andThen(divide).accept(10, 5);
        System.out.println();

        // Student operations
        System.out.println("Student Information:");
        printStudentNameAndHobbies(StudentUtils.getStudentList());
    }

    /**
     * Prints student name and hobbies using BiConsumer.
     */
    private static void printStudentNameAndHobbies(List<Student> studentList) {
        BiConsumer<String, List<String>> printNameAndHobbies =
            (name, hobbies) -> System.out.println(name + " - " + hobbies);
        
        studentList.forEach(student ->
            printNameAndHobbies.accept(
                student.getFirstName() + " " + student.getLastName(),
                student.getHobbies()
            )
        );
    }
}
