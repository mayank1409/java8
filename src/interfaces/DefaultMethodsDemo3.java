package interfaces;

import java.util.Arrays;
import java.util.List;

public class DefaultMethodsDemo3 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5);
        Multipler multipler = new MultiplierImpl();
        int result = multipler.multiply(integers);
        System.out.println("Is List Empty " + Multipler.isEmpty(integers));
        System.out.println("Size of List " + multipler.size(integers));
        System.out.println("Multiply " + result);
    }
}


interface Multipler {

    int multiply(List<Integer> integers);

    default int size(List<Integer> integers) {
        System.out.println("Inside Multiplier Interface");
        return integers.size();
    }

    static boolean isEmpty(List<Integer> integers) {
        return integers.isEmpty();
    }

}

class MultiplierImpl implements Multipler {

    @Override
    public int multiply(List<Integer> integers) {
        return integers.stream().reduce(1, (a, b) -> a*b).intValue();
    }

    @Override
    public int size(List<Integer> integers) {
        System.out.println("Inside MultiplierImpl class");
        return integers.size();
    }
}