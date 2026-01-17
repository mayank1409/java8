package optional;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Optional;

/**
 * Demonstrates Java 8 Optional API for handling null values elegantly.
 * Shows methods: map, orElse, orElseGet, ifPresent, filter, flatMap, isPresent, isEmpty, of, empty.
 */
public class OptionalDemo {

    /**
     * Helper method: Get student name with default fallback.
     * @return student first name or "Default" if not found
     */
    public static String getStudentName() {
        Optional<Student> optional = Optional.ofNullable(StudentUtils.studentSupplier2.get());
        return optional.map(Student::getFirstName).orElseGet(() -> "Default");
    }

    /**
     * Helper method: Get optional string value.
     * @return Optional containing "Hello, World"
     */
    public static Optional<String> getLength() {
        return Optional.ofNullable("Hello, World");
    }

    public static void main(String[] args) {
        // Example 1: map() and orElseGet()
        System.out.println("===== Example 1: map() and orElseGet() =====");
        System.out.println("Name: " + getStudentName());
        System.out.println("Length: " + getStudentName().length());

        // Example 2: isPresent() with conditional
        System.out.println("\n===== Example 2: isPresent() with conditional =====");
        if (getLength().isPresent()) {
            System.out.println("String present - Length: " + getLength().get().length());
        } else {
            System.out.println("String not present");
        }

        // Example 3: Optional.of() - guaranteed non-null value
        System.out.println("\n===== Example 3: Optional.of() (non-null guarantee) =====");
        Optional<String> nonNullString = Optional.of("Hello, World");
        if (nonNullString.isPresent()) {
            System.out.println("Value: " + nonNullString.get().toUpperCase());
        }

        // Example 4: Optional.empty() and isEmpty()
        System.out.println("\n===== Example 4: Optional.empty() and isEmpty() =====");
        Optional<Object> empty = Optional.empty();
        if (empty.isEmpty()) {
            System.out.println("Optional is empty!");
        }

        // Example 5: map() with orElse()
        System.out.println("\n===== Example 5: map() with orElse() =====");
        Optional<Student> student = Optional.ofNullable(StudentUtils.studentSupplier.get());
        String name = student.map(Student::getFirstName).orElse("Default");
        System.out.println("Student name (orElse): " + name);

        // Example 6: map() with orElseGet() - lazy evaluation
        System.out.println("\n===== Example 6: map() with orElseGet() (lazy evaluation) =====");
        Optional<Student> student2 = Optional.ofNullable(StudentUtils.studentSupplier2.get());
        String name2 = student2.map(Student::getFirstName).orElseGet(() -> "Default");
        System.out.println("Student name (orElseGet): " + name2);

        // Example 7: filter() with predicate
        System.out.println("\n===== Example 7: filter() with predicate (name length > 4) =====");
        Optional<Student> student3 = Optional.ofNullable(StudentUtils.studentSupplier.get());
        student3.filter(s -> s.getFirstName().length() > 4)
                .ifPresent(s -> System.out.println("Filtered student CGPA: " + s.getCgpa()));

        // Example 8: ifPresent() action
        System.out.println("\n===== Example 8: ifPresent() action =====");
        Optional<Student> student4 = Optional.ofNullable(StudentUtils.studentSupplier2.get());
        if (student4.isPresent()) {
            System.out.println("Student found: " + student4.map(Student::getFirstName).get());
        }

        // Example 9: flatMap() - chaining Optionals
        System.out.println("\n===== Example 9: flatMap() (chaining Optionals) =====");
        Optional<Student> student5 = Optional.ofNullable(StudentUtils.studentSupplier.get());
        student5.flatMap(Student::getBike).ifPresent(System.out::println);
    }
}
