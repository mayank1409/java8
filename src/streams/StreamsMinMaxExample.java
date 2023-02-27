package streams;

import java.util.Arrays;
import java.util.List;

public class StreamsMinMaxExample {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 6, 4, 3, 1000, 9000, 299, 33, 999);
        int maxValue = integerList.stream().reduce(Integer::max).get();
        System.out.println(maxValue);

        Integer minValue = integerList.stream().reduce(Integer::min).get();
        System.out.println(minValue);
    }
}
