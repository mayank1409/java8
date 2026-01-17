package demo;

import java.util.stream.IntStream;

public class ImperativeVsDeclarativeDemo {
    public static void main(String[] args) {

        // Imperative Style of Programming
        int s1 = 0;
        for (int i = 1; i <= 500; i++) {
            s1 += i;
        }
        System.out.println(s1);

        // Declarative style of Programming
        int s2 = IntStream.rangeClosed(1, 500).sum();
        System.out.println(s2);

    }
}
