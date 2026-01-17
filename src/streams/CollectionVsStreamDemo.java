package streams;

import java.util.ArrayList;

/**
 * Demonstrates differences between Collections and Streams.
 * Shows imperative (collection) vs declarative (stream) approaches.
 */
public class CollectionVsStreamDemo {
    
    public static void main(String[] args) {
        System.out.println("===== Collections vs Streams =====");
        
        // Imperative approach using ArrayList
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Paul");
        names.add("Jimmy");

        System.out.println("\nCollection approach:");
        System.out.println("First element: " + names.get(0));
        System.out.println("Removed element: " + names.remove(1));

        // Declarative approach using Streams
        System.out.println("\nStream approach:");
        names.stream().forEach(System.out::println);
    }
}
