package streams;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates finding min and max values in a stream using reduce operation.
 */
public class StreamsMinMaxExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 6, 4, 3, 1000, 9000, 299, 33, 999);
        
        // Finding maximum value using reduce
        System.out.println("===== Finding maximum value =====");
        int maxValue = integerList.stream().reduce(Integer::max).get();
        System.out.println("Maximum value: " + maxValue);

        // Finding minimum value using reduce
        System.out.println("\n===== Finding minimum value =====");
        Integer minValue = integerList.stream().reduce(Integer::min).get();
        System.out.println("Minimum value: " + minValue);
    }
}
