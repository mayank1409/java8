package interfaces;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates default and static methods in interfaces (Java 8 feature).
 * Shows how interfaces can provide method implementations and utility methods.
 */
public class DefaultAndStaticMethodsInInterfacesDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5);
        Multiplier multiplier = new MultiplierImpl();
        
        // Call abstract method (must be implemented by concrete class)
        int result = multiplier.multiply(numbers);
        System.out.println("Result of multiply: " + result);
        
        // Call default method (can be overridden or use default implementation)
        System.out.println("Size using default method: " + multiplier.size(numbers));
        
        // Call static method (utility, cannot be overridden)
        System.out.println("Is list empty: " + Multiplier.isEmpty(numbers));
    }
}

/**
 * Interface showing Java 8 features:
 * - Abstract method: multiply() - must be implemented by implementing classes
 * - Default method: size() - has implementation, can be overridden
 * - Static method: isEmpty() - utility method, cannot be overridden
 */
interface Multiplier {

    /**
     * Abstract method: Multiply all elements in the list.
     */
    int multiply(List<Integer> integers);

    /**
     * Default method: Can be overridden by implementing classes if needed.
     */
    default int size(List<Integer> integers) {
        System.out.println("[Multiplier Interface] Calculating size...");
        return integers.size();
    }

    /**
     * Static method: Utility function, cannot be overridden.
     */
    static boolean isEmpty(List<Integer> integers) {
        return integers.isEmpty();
    }
}

/**
 * Implementation of Multiplier interface.
 * Implements abstract method and overrides default method.
 */
class MultiplierImpl implements Multiplier {

    /**
     * Multiply all elements using stream reduction.
     */
    @Override
    public int multiply(List<Integer> integers) {
        return integers.stream()
            .reduce(1, (a, b) -> a * b);
    }

    /**
     * Override default method with custom implementation.
     */
    @Override
    public int size(List<Integer> integers) {
        System.out.println("[MultiplierImpl Class] Custom size calculation...");
        return integers.size();
    }
}