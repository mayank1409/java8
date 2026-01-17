package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Demonstrates map and flatMap transformations on streams.
 * Shows single transformations, flattening nested collections, and sorting with multiple comparators.
 */
public class StreamsMapDemo {

    public static void main(String[] args) {
        List<Student> students = StudentUtils.getStudentList();

        // Mapping to full names with transformation
        System.out.println("===== Mapping to full names (uppercase) =====");
        List<String> fullNames = students.stream()
                .map(student -> student.getFirstName() + " " + student.getLastName())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(fullNames);

        // FlatMap to extract all hobbies into a single stream
        System.out.println("\n===== FlatMap to extract all hobbies =====");
        Set<String> uniqueHobbies = students.stream()
                .map(Student::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println("Unique hobbies: " + uniqueHobbies);

        // Count distinct hobbies
        System.out.println("\n===== Count distinct hobbies =====");
        long totalUniqueHobbies = students.stream()
                .map(Student::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println("Total distinct hobbies: " + totalUniqueHobbies);

        // Filter hobbies by matching all items in a list
        System.out.println("\n===== Students with specific hobbies =====");
        List<String> targetHobbies = Arrays.asList("swimming", "news", "Tennis");
        long matchingStudents = students.stream()
                .map(Student::getHobbies)
                .filter(hobbies -> targetHobbies.containsAll(hobbies))
                .count();
        System.out.println("Students with all target hobbies: " + matchingStudents);

        // Sort by multiple criteria: last name, then first name
        System.out.println("\n===== Students sorted by last name, then first name =====");
        List<String> sortedByName = students.stream()
                .sorted(Comparator.comparing(Student::getLastName)
                        .thenComparing(Student::getFirstName))
                .map(Student::getFirstName)
                .collect(Collectors.toList());
        System.out.println(sortedByName);

        // Sort by CGPA in descending order
        System.out.println("\n===== Students sorted by CGPA (descending) =====");
        List<String> sortedByCgpa = students.stream()
                .sorted(Comparator.comparingDouble(Student::getCgpa).reversed())
                .map(Student::getFirstName)
                .collect(Collectors.toList());
        System.out.println(sortedByCgpa);
    }
}
