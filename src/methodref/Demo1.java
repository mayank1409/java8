package methodref;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Demonstrates method references as shorthand for lambda expressions.
 * Shows different types of method references: static, instance, and constructor.
 */
public class Demo1 {

    // Lambda expression vs Method reference comparison
    static Function<String, String> usingLambda = s -> s.toUpperCase();
    static Function<String, String> usingMethodReference = String::toUpperCase;

    static Consumer<String> printConsumer = System.out::println;

    static Consumer<Student> printStudentHobbies = Student::printHobbies;

    public static void main(String[] args) {
        // Using lambda expression
        String result1 = usingLambda.apply("java8");
        System.out.println("Lambda result: " + result1);

        // Using method reference (cleaner and more readable)
        String result2 = usingMethodReference.apply("hello java8");
        System.out.println("Method reference result: " + result2);

        // Using method reference for Consumer (System.out::println)
        System.out.println("\nUsing Consumer method reference:");
        String transformed = usingMethodReference.apply("hello java 8");
        printConsumer.accept(transformed);

        // Method reference with Student objects
        System.out.println("\nStudent hobbies:");
        StudentUtils.getStudentList().forEach(printStudentHobbies);
    }
}
