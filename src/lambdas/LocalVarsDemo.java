package lambdas;

import java.util.function.Consumer;

public class LocalVarsDemo {

    public static void main(String[] args) {
        int i = 0;
        // Consumer<Integer> integerConsumer = i -> System.out.println(i);
        Consumer<Integer> integerConsumer = i1 -> System.out.println(i1);

        int value = 4;
        Consumer<Integer> c1 = x -> {
            // value++; Variable used in lambda expression should be final or effectively final
            System.out.println(value + x);
        };
        c1.accept(4);
    }
}
