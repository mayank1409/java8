package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinctDemo {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,4,3,2,10);

        List<Integer> uniqueList = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            if (!uniqueList.contains(integerList.get(i))) {
                uniqueList.add(integerList.get(i));
            }
        }
        System.out.println(uniqueList);

        List<Integer> uniqueList2 = integerList.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueList2);
    }
}
