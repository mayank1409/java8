package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

/**
 * Demonstrates summingInt and averagingInt collectors for aggregating numeric values.
 */
public class StreamsSumAvgDemo {

    public static void main(String[] args) {
        // Calculating total notebooks
        System.out.println("===== Summing notebooks =====");
        Integer totalNotebooks = StudentUtils.getStudentList().stream()
                .collect(summingInt(Student::getNotebooks));
        System.out.println("Total notebooks: " + totalNotebooks);

        // Calculating average notebooks
        System.out.println("\n===== Average notebooks per student =====");
        Double avgNotebooks = StudentUtils.getStudentList().stream()
                .collect(averagingInt(Student::getNotebooks));
        System.out.println("Average notebooks: " + avgNotebooks);
    }
}
