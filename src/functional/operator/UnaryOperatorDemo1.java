package functional.operator;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo1 {

    public static void main(String[] args) {

        UnaryOperator<String> stringUnaryOperator = s -> s.concat("default");
        String string = stringUnaryOperator.apply("JAVA");
        System.out.println(string);

        BinaryOperator<String> stringBinaryOperator = (s1, s2) -> s1.concat(s2);
        String result = stringBinaryOperator.apply("Java", "DEFAULT");
        System.out.println(result);

        BinaryOperator<Integer> integerBinaryOperator = (a, b) -> a*b;
        Integer multiply = integerBinaryOperator.apply(10, 20);
        System.out.println("Multiplication : " + multiply);

        Comparator<Integer> integerComparator = (a, b) -> a.compareTo(b);

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(integerComparator);
        System.out.println(maxBy.apply(4, 3));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(integerComparator);
        System.out.println(minBy.apply(4, 5));

    }
}
