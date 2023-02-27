package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamsDemo {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int i = integerList.stream().reduce(0, Integer::sum).intValue();
        System.out.println(i);

        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println(sum);

        int sum1 = IntStream.range(1, 10).sum();
        System.out.println(sum1);

        System.out.println(IntStream.range(1, 10).count());
        System.out.println(IntStream.rangeClosed(1, 10).count());

        System.out.println(LongStream.rangeClosed(1, 1000000).count());

        IntStream.rangeClosed(1, 10).asDoubleStream().forEach(x -> System.out.print(x + " "));

        System.out.println();
        System.out.println("==================================================================");

        System.out.println(IntStream.rangeClosed(1, 50).average().getAsDouble());
        System.out.println(IntStream.rangeClosed(1, 50).sum());
        System.out.println(IntStream.rangeClosed(1, 50).max().getAsInt());
        System.out.println(IntStream.rangeClosed(1, 50).min().getAsInt());

        System.out.println("==================================================================");

        System.out.println(LongStream.rangeClosed(100, 1000).sum());
        System.out.println(LongStream.rangeClosed(50, 100).min().getAsLong());
        System.out.println(LongStream.rangeClosed(100, 1000).max().getAsLong());
        System.out.println(LongStream.rangeClosed(100, 1000).average().getAsDouble());

        System.out.println("==================================================================");

        List<Integer> integers = IntStream.rangeClosed(100, 500)
                .boxed().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(integers);

        integers.stream().mapToInt(Integer::intValue).forEach(x -> System.out.print(x + " "));


        System.out.println("\n" + LongStream.rangeClosed(100, 10000).boxed().max(Comparator.comparing(Long::longValue)).get());

        System.out.println("==================================================================");

        List<Integer> intList = IntStream.rangeClosed(200, 1000).mapToObj(Integer::valueOf).collect(Collectors.toList());
        System.out.println(intList);

        List<Long> longList = IntStream.rangeClosed(20, 50).mapToLong(Long::valueOf).boxed().collect(Collectors.toList());
        System.out.println(longList);


        List<Long> longs = LongStream.rangeClosed(10, 20).mapToObj(Long::valueOf).collect(Collectors.toList());
        System.out.println(longs);

    }
}
