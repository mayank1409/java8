package parallel.streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Demonstrates sequential vs parallel streams performance comparison.
 * Shows that parallel streams may not always be faster for small datasets due to overhead.
 * Available processors on this system affects parallel execution.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println();

        // Extract hobbies: Sequential vs Parallel
        getHobbiesOfStudentSequential();
        getHobbiesOfStudentsParallel();

        System.out.println();

        // Sum range: Sequential vs Parallel
        sumSequentialStreams();
        sumParallelStream();

        System.out.println();

        // Thread-safety example
        demonstrateThreadSafety();
    }

    /**
     * Sequential stream extraction of hobbies from student list.
     * Baseline performance for comparison.
     */
    private static void getHobbiesOfStudentSequential() {
        System.out.println("===== Extracting hobbies (Sequential) =====");
        long startTime = System.currentTimeMillis();
        Set<String> hobbies = StudentUtils.getStudentList().stream()
                .map(Student::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Found hobbies: " + hobbies);
        System.out.println("Sequential operation took: " + duration + " ms");
    }

    /**
     * Parallel stream extraction of hobbies from student list.
     * May show better performance for larger datasets.
     */
    private static void getHobbiesOfStudentsParallel() {
        System.out.println("\n===== Extracting hobbies (Parallel) =====");
        long startTime = System.currentTimeMillis();
        Set<String> hobbies = StudentUtils.getStudentList().stream()
                .parallel()
                .map(Student::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Found hobbies: " + hobbies);
        System.out.println("Parallel operation took: " + duration + " ms");
    }

    /**
     * Sequential stream sum of numbers 1-100000.
     */
    private static void sumSequentialStreams() {
        System.out.println("===== Summing 1-100000 (Sequential) =====");
        long startTime = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 100000).sum();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Sum: " + sum);
        System.out.println("Sequential operation took: " + duration + " ms");
    }

    /**
     * Parallel stream sum of numbers 1-100000.
     * Demonstrates that parallel overhead can exceed benefits for smaller datasets.
     */
    private static void sumParallelStream() {
        System.out.println("\n===== Summing 1-100000 (Parallel) =====");
        long startTime = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 100000).parallel().sum();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Sum: " + sum);
        System.out.println("Parallel operation took: " + duration + " ms");
    }

    /**
     * Demonstrates thread-safety issues with mutable accumulators in parallel streams.
     * Shows non-deterministic behavior when using unsynchronized mutable state.
     */
    private static void demonstrateThreadSafety() {
        System.out.println("===== Thread Safety Example (Sequential) =====");
        Sum sequentialSum = new Sum();
        IntStream.rangeClosed(1, 1000)
                .forEach(sequentialSum::performSum);
        System.out.println("Sequential sum (1-1000): " + sequentialSum.getTotal());

        System.out.println("\n===== Thread Safety Example (Parallel - May be incorrect) =====");
        Sum parallelSum = new Sum();
        IntStream.rangeClosed(1, 1000)
                .parallel()
                .forEach(parallelSum::performSum);
        System.out.println("Parallel sum (1-1000): " + parallelSum.getTotal());
        System.out.println("Note: Parallel result may differ due to lack of synchronization!");
    }
}

/**
 * Helper class demonstrating mutable accumulator for sum operations.
 * WARNING: Not thread-safe and should not be used with parallel streams.
 */
class Sum {
    private long total;

    /**
     * Get the accumulated total.
     * @return the total sum
     */
    public long getTotal() {
        return total;
    }

    /**
     * Set the total sum value.
     * @param total the total to set
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * Add a value to the total (NOT thread-safe).
     * @param input the value to add
     */
    public void performSum(int input) {
        total += input;
    }
}
