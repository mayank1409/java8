package functional.consumerandpredicate;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Demonstrates combining Predicate and BiConsumer using functional composition.
 * Filters students by CGPA threshold and prints their information.
 */
public class Demo1 {

    // Predicate: Select students with CGPA > 9.0
    private static Predicate<Student> highCgpaPredicate = student -> student.getCgpa() > 9.0;

    // BiConsumer: Print student name and hobbies
    private static BiConsumer<String, List<String>> printNameAndHobbies =
        (name, hobbies) -> System.out.println(name + " - " + hobbies);

    // Consumer: Filter student and print if predicate is satisfied
    private static Consumer<Student> filterAndPrint = student -> {
        if (highCgpaPredicate.test(student)) {
            String fullName = student.getFirstName() + " " + student.getLastName();
            printNameAndHobbies.accept(fullName, student.getHobbies());
        }
    };

    public static void main(String[] args) {
        System.out.println("Students with CGPA > 9.0:");
        printHighCgpaStudents();
    }

    /**
     * Prints names and hobbies of students meeting the CGPA criteria.
     */
    public static void printHighCgpaStudents() {
        StudentUtils.getStudentList().forEach(filterAndPrint);
    }
}
