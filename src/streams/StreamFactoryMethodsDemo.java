package streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Demonstrates stream factory methods: of(), iterate(), and generate().
 * Shows different ways to create streams from various sources.
 */
public class StreamFactoryMethodsDemo {

    public static void main(String[] args) {
        // Stream.of(): Create stream from varargs
        System.out.println("===== Stream.of() =====");
        Stream<String> names = Stream.of("Adam", "John", "Hopkins", "William", "Dan");
        names.forEach(System.out::println);

        // Stream.iterate(): Create infinite stream with function
        System.out.println("\n===== Stream.iterate() - powers of 2 =====");
        Stream.iterate(1, x -> x * 2)
                .limit(10)
                .forEach(System.out::println);

        // Stream.generate(): Create stream from supplier
        System.out.println("\n===== Stream.generate() - random numbers =====");
        Supplier<Integer> randomSupplier = new Random()::nextInt;
        Stream.generate(randomSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
