package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Demonstrates specialized numeric streams: IntStream, LongStream.
 * Shows operations like range, rangeClosed, sum, average, min, max, boxing, and conversions.
 */
public class NumericStreamsDemo {

    public static void main(String[] args) {
        // List to IntStream conversion with sum
        System.out.println("===== Integer List to IntStream =====");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumFromList = integerList.stream().reduce(0, Integer::sum).intValue();
        System.out.println("Sum from list: " + sumFromList);

        // IntStream range vs rangeClosed
        System.out.println("\n===== IntStream range vs rangeClosed =====");
        int rangeClosedSum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum (1-10 inclusive): " + rangeClosedSum);

        int rangeSum = IntStream.range(1, 10).sum();
        System.out.println("Sum (1-9): " + rangeSum);

        // Counting elements
        System.out.println("\n===== Counting elements =====");
        System.out.println("Count (range): " + IntStream.range(1, 10).count());
        System.out.println("Count (rangeClosed): " + IntStream.rangeClosed(1, 10).count());
        System.out.println("LongStream count (1-1000000): " + LongStream.rangeClosed(1, 1000000).count());

        // Converting to DoubleStream
        System.out.println("\n===== Converting IntStream to DoubleStream =====");
        IntStream.rangeClosed(1, 10).asDoubleStream().forEach(x -> System.out.print(x + " "));

        // IntStream statistics
        System.out.println("\n\n===== IntStream statistics (1-50) =====");
        System.out.println("Average: " + IntStream.rangeClosed(1, 50).average().getAsDouble());
        System.out.println("Sum: " + IntStream.rangeClosed(1, 50).sum());
        System.out.println("Max: " + IntStream.rangeClosed(1, 50).max().getAsInt());
        System.out.println("Min: " + IntStream.rangeClosed(1, 50).min().getAsInt());

        // LongStream statistics
        System.out.println("\n===== LongStream statistics (100-1000) =====");
        System.out.println("Sum: " + LongStream.rangeClosed(100, 1000).sum());
        System.out.println("Min: " + LongStream.rangeClosed(50, 100).min().getAsLong());
        System.out.println("Max: " + LongStream.rangeClosed(100, 1000).max().getAsLong());
        System.out.println("Average: " + LongStream.rangeClosed(100, 1000).average().getAsDouble());

        // Boxing: IntStream to List<Integer>
        System.out.println("\n===== Boxing IntStream to List<Integer> =====");
        List<Integer> integers = IntStream.rangeClosed(100, 500)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("First 5 (descending): " + integers.stream().limit(5).collect(Collectors.toList()));

        // Converting back to primitive stream and printing
        System.out.println("\nFirst 10 elements:");
        integers.stream().mapToInt(Integer::intValue).limit(10).forEach(x -> System.out.print(x + " "));

        // LongStream boxing with max
        System.out.println("\n\n===== LongStream max after boxing =====");
        Long maxLong = LongStream.rangeClosed(100, 10000)
                .boxed()
                .max(Comparator.comparing(Long::longValue))
                .get();
        System.out.println("Max value: " + maxLong);

        // Boxing with mapToObj
        System.out.println("\n===== Boxing with mapToObj =====");
        List<Integer> intList = IntStream.rangeClosed(200, 210)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println("Integer list: " + intList);

        List<Long> longList = IntStream.rangeClosed(20, 30)
                .mapToLong(Long::valueOf)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Long list (from IntStream): " + longList);

        List<Long> longs = LongStream.rangeClosed(10, 20)
                .mapToObj(Long::valueOf)
                .collect(Collectors.toList());
        System.out.println("Long list (from LongStream): " + longs);
    }
}
