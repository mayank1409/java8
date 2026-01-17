package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

/**
 * Demonstrates partitioningBy collector for dividing stream elements into two groups.
 * Shows variations: partitioning into List and partitioning into Set.
 */
public class StreamsPartitioningDemo {

    public static void main(String[] args) {
        // Partitioning into List by CGPA threshold
        System.out.println("===== Partitioning by CGPA > 9 (into List) =====");
        Map<Boolean, List<Student>> partitionedLists = StudentUtils.getStudentList().stream()
                .collect(Collectors.partitioningBy(student -> student.getCgpa() > 9));
        System.out.println("Outstanding (CGPA > 9): " + partitionedLists.get(true).size() + " students");
        System.out.println("Average (CGPA <= 9): " + partitionedLists.get(false).size() + " students");

        // Partitioning into Set by CGPA threshold
        System.out.println("\n===== Partitioning by CGPA > 9 (into Set) =====");
        Map<Boolean, Set<Student>> partitionedSets = StudentUtils.getStudentList().stream()
                .collect(Collectors.partitioningBy(student -> student.getCgpa() > 9, toSet()));
        System.out.println("Outstanding students: " + partitionedSets.get(true));
        System.out.println("Average students: " + partitionedSets.get(false));
    }
}
