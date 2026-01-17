package interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates default methods in interfaces introduced in Java 8.
 * Compares traditional approach (Collections.sort) with Java 8 approach (List.sort).
 */
public class DefaultMethodsDemo {
    
    public static void main(String[] args) {
        // Pre-Java 8: Using Collections.sort() utility method
        System.out.println("===== Pre-Java 8 Approach =====");
        List<String> names = Arrays.asList("Dan", "Jenny", "Alex", "Adam", "John");
        System.out.println("Before sorting: " + names);
        Collections.sort(names);
        System.out.println("After sorting:  " + names);

        System.out.println("\n===== Java 8 Approach (using default method) =====");
        // Java 8: Using default method sort() directly on List interface
        List<String> strings = Arrays.asList("Dan", "Jenny", "Alex", "Adam", "John");
        System.out.println("Before sorting: " + strings);
        
        // Natural order (ascending)
        strings.sort(Comparator.naturalOrder());
        System.out.println("After natural order sort: " + strings);
        
        // Reverse order (descending)
        strings.sort(Comparator.reverseOrder());
        System.out.println("After reverse order sort: " + strings);
    }
}
