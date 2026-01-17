package functional.operator;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Demonstrates UnaryOperator and BinaryOperator usage.
 * Shows string concatenation, arithmetic operations, and comparisons using operators.
 */
public class UnaryOperatorTransformationDemo {

    public static void main(String[] args) {
        // UnaryOperator: Appends "8" to input string
        UnaryOperator<String> appendVersion = str -> str.concat("8");
        String result1 = appendVersion.apply("JAVA");
        System.out.println("UnaryOperator result: " + result1);
        System.out.println();

        // BinaryOperator for string concatenation
        BinaryOperator<String> concatenate = (str1, str2) -> str1.concat(str2);
        String result2 = concatenate.apply("Java", "8");
        System.out.println("BinaryOperator (concatenate) result: " + result2);
        System.out.println();

        // BinaryOperator for multiplication
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        Integer multiplyResult = multiply.apply(10, 20);
        System.out.println("BinaryOperator (multiply) result: " + multiplyResult);
        System.out.println();

        // BinaryOperator using maxBy and minBy with Comparator
        Comparator<Integer> naturalOrder = Comparator.naturalOrder();

        BinaryOperator<Integer> max = BinaryOperator.maxBy(naturalOrder);
        System.out.println("Max of 4 and 3: " + max.apply(4, 3));

        BinaryOperator<Integer> min = BinaryOperator.minBy(naturalOrder);
        System.out.println("Min of 4 and 5: " + min.apply(4, 5));
    }
}
