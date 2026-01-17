package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.stream.Collectors;

/**
 * Demonstrates skip() and limit() stream operations.
 * Skip first 2 students, limit to next 2, then collect first names.
 */
public class LimitsAndSkipDemo {

    public static void main(String[] args) {
        System.out.println("Students at index 2-3 (skip 2, limit 2):");
        var names = StudentUtils.getStudentList().stream()
                .skip(2)
                .limit(2)
                .map(Student::getFirstName)
                .collect(Collectors.toList());
        
        System.out.println(names);
    }
}
