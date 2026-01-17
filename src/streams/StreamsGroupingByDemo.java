package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Demonstrates groupingBy collector for grouping stream elements by key.
 * Shows variations: simple grouping, conditional grouping, counting, and aggregation operations.
 */
public class StreamsGroupingByDemo {

    public static void main(String[] args) {

        // Grouping by gender
        System.out.println("===== Grouping by Gender =====");
        Map<String, List<Student>> genderGroups = StudentUtils.getStudentList().stream()
                .collect(groupingBy(Student::getGender));
        System.out.println(genderGroups);

        // Grouping hobbies by list size
        System.out.println("\n===== Hobbies grouped by size =====");
        List<List<String>> hobbiesList = StudentUtils.getStudentList().stream()
                .map(Student::getHobbies)
                .sorted(Comparator.comparing(List::size))
                .collect(toList());
        System.out.println(hobbiesList);

        // Conditional grouping: Outstanding vs Average
        System.out.println("\n===== Conditional grouping: Outstanding vs Average (CGPA > 9) =====");
        Map<String, List<Student>> performanceGroups = StudentUtils.getStudentList().stream()
                .collect(groupingBy(student -> student.getCgpa() > 9 ? "OUTSTANDING" : "AVERAGE"));

        List<String> outstandingStudents = performanceGroups.get("OUTSTANDING").stream()
                .map(Student::getFirstName)
                .collect(Collectors.toList());
        System.out.println("Outstanding: " + outstandingStudents);

        List<String> averageStudents = performanceGroups.get("AVERAGE").stream()
                .map(Student::getFirstName)
                .collect(Collectors.toList());
        System.out.println("Average: " + averageStudents);

        // Grouping with summingInt collector
        System.out.println("\n===== Grouping with summingInt (Total notebooks per student) =====");
        Map<String, Integer> notebooksByStudent = StudentUtils.getStudentList().stream()
                .collect(groupingBy(Student::getFirstName,
                        summingInt(Student::getNotebooks)));
        System.out.println(notebooksByStudent);

        // Grouping with custom map type (LinkedHashMap preserves insertion order)
        System.out.println("\n===== Grouping with LinkedHashMap (preserves insertion order) =====");
        LinkedHashMap<String, Integer> orderedNotebooks = StudentUtils.getStudentList().stream()
                .collect(groupingBy(Student::getFirstName, LinkedHashMap::new,
                        summingInt(Student::getNotebooks)));
        System.out.println(orderedNotebooks);

        // Grouping with minBy collector
        System.out.println("\n===== Grouping with minBy (Lowest CGPA by performance category) =====");
        Map<String, Optional<Student>> minCgpaByCategory = StudentUtils.getStudentList().stream()
                .collect(groupingBy(student -> student.getCgpa() > 9 ? "OUTSTANDING" : "AVERAGE",
                        minBy(Comparator.comparing(Student::getCgpa))));

        System.out.println("Min CGPA (Outstanding): " + minCgpaByCategory.get("OUTSTANDING").get().getFirstName());
        System.out.println("Min CGPA (Average): " + minCgpaByCategory.get("AVERAGE").get().getFirstName());

        // Grouping with collectingAndThen (maxBy with unwrapping)
        System.out.println("\n===== Grouping with collectingAndThen (Highest CGPA by category) =====");
        Map<String, Student> maxCgpaByCategory = StudentUtils.getStudentList().stream()
                .collect(groupingBy(student -> student.getCgpa() > 9 ? "OUTSTANDING" : "AVERAGE",
                        collectingAndThen(maxBy(Comparator.comparing(Student::getCgpa)), Optional::get)));

        System.out.println("Max CGPA (Outstanding): " + maxCgpaByCategory.get("OUTSTANDING").getFirstName());
    }
}
