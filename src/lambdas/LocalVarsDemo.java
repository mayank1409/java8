package lambdas;

import java.util.function.Consumer;

/**
 * Demonstrates lambda expressions with local variables.
 * Shows the effectively final requirement: variables used in lambdas must not change after assignment.
 */
public class LocalVarsDemo {

    public static void main(String[] args) {
        // Example 1: Avoiding parameter shadowing
        // Lambda parameter 'i1' shadows outer variable 'i' (which is effectively final)
        Consumer<Integer> printInput = i1 -> System.out.println("Input: " + i1);
        printInput.accept(5);
        System.out.println();

        // Example 2: Effectively final local variable in lambda
        // Variable 'value' is effectively final (never reassigned after initialization)
        // It can be used in the lambda expression
        int value = 4;
        Consumer<Integer> addToValue = x -> {
            // value++; // This would cause compilation error - violates effectively final requirement
            System.out.println("Sum: " + (value + x));
        };
        addToValue.accept(4);
    }
}
