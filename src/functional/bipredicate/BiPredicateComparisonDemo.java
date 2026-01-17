package functional.bipredicate;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

/**
 * Demonstrates BiPredicate usage combining multiple conditions.
 * Filters and displays students based on CGPA and hobby criteria.
 */
public class BiPredicateComparisonDemo {

    private static final List<String> REQUIRED_HOBBIES = Arrays.asList("swimming", "news", "Tennis");

    // BiPredicate: CGPA > 7.0 AND student has all required hobbies
    private static BiPredicate<Double, List<String>> cgpaAndHobbiesPredicate =
        (cgpa, hobbies) -> cgpa > 7.0 && REQUIRED_HOBBIES.containsAll(hobbies);

    // BiConsumer: Print student name and hobbies
    private static BiConsumer<String, List<String>> printNameAndHobbies =
        (name, hobbies) -> System.out.println(String.format("%s's hobbies: %s", name, hobbies));

    // Consumer: Filter and print students using the predicate
    private static Consumer<Student> filterAndPrintStudent = student -> {
        if (cgpaAndHobbiesPredicate.test(student.getCgpa(), student.getHobbies())) {
            printNameAndHobbies.accept(student.getFirstName(), student.getHobbies());
        }
    };

    public static void main(String[] args) {
        System.out.println("Students with CGPA > 7.0 and required hobbies:");
        printQualifyingStudents();
    }

    /**
     * Filters and prints students meeting the criteria.
     */
    private static void printQualifyingStudents() {
        StudentUtils.getStudentList().forEach(filterAndPrintStudent);
    }
}
