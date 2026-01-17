package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

/**
 * Demonstrates mapping collector for transforming and collecting stream elements.
 * Shows variations: mapping to List and mapping to Set.
 */
public class StreamsMappingDemo {

    public static void main(String[] args) {
        // Mapping to List
        System.out.println("===== Mapping to List =====");
        List<String> firstNamesList = StudentUtils.getStudentList().stream()
                .collect(mapping(Student::getFirstName, toList()));
        System.out.println("First names (List): " + firstNamesList);

        // Mapping to Set
        System.out.println("\n===== Mapping to Set (removes duplicates) =====");
        Set<String> firstNamesSet = StudentUtils.getStudentList().stream()
                .collect(mapping(Student::getFirstName, toSet()));
        System.out.println("First names (Set): " + firstNamesSet);
    }
}
