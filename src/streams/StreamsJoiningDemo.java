package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import static java.util.stream.Collectors.joining;

/**
 * Demonstrates joining collector for concatenating stream elements.
 * Shows variations: without delimiter, with delimiter, and with prefix/suffix.
 */
public class StreamsJoiningDemo {

    public static void main(String[] args) {
        // Joining without delimiter
        System.out.println("===== Joining without delimiter =====");
        String names = StudentUtils.getStudentList().stream()
                .map(Student::getFirstName)
                .collect(joining());
        System.out.println(names);

        // Joining with delimiter
        System.out.println("\n===== Joining with delimiter =====");
        String namesWithDelimiter = StudentUtils.getStudentList().stream()
                .map(Student::getFirstName)
                .collect(joining("-"));
        System.out.println(namesWithDelimiter);

        // Joining with delimiter, prefix, and suffix
        System.out.println("\n===== Joining with delimiter, prefix, and suffix =====");
        String namesWithPrefixAndSuffix = StudentUtils.getStudentList().stream()
                .map(Student::getFirstName)
                .collect(joining("-", "{", "}"));
        System.out.println(namesWithPrefixAndSuffix);
    }
}
