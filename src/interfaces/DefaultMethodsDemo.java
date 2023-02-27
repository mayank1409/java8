package interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsDemo {
    public static void main(String[] args) {

        // prior to Java 8
        List<String> names = Arrays.asList("Dan", "Jenny", "Alex", "Adam", "John");
        System.out.println("Before Sorting " + names);
        Collections.sort(names);
        System.out.println("After Sorting " + names);

        System.out.println("==========================================");

        //Java 8
        List<String> strings = Arrays.asList("Dan", "Jenny", "Alex", "Adam", "John");
        System.out.println("Before sorting " + strings);
        strings.sort(Comparator.naturalOrder());
        System.out.println("After sorting " + strings);
        strings.sort(Comparator.reverseOrder());
        System.out.println("After reverse sorting " + strings);

    }
}
