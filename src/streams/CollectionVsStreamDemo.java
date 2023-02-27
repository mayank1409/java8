package streams;

import java.util.ArrayList;

public class CollectionVsStreamDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Paul");
        names.add("Jimmy");

        System.out.println(names.get(0));
        System.out.println(names.remove(1));

        names.stream().forEach(System.out::println);
    }
}
