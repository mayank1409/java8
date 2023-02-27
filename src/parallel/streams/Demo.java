package parallel.streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println();

        getHobbiesOfStudentSequential();
        getHobbiesOfStudentsParallel();

        System.out.println();

        sumSequentialStreams();
        sumParallelStream();

        System.out.println();

        Sum sumClient = new Sum();
        IntStream.rangeClosed(1, 1000).forEach(sumClient::performSum);
        System.out.println(sumClient.getTotal());
    }

    private static void getHobbiesOfStudentSequential() {long startTime = System.currentTimeMillis();
        Set<String> stringList = StudentUtils.getStudentList().stream()
                .map(Student::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println(stringList);
        System.out.println("Seq operation took " + (System.currentTimeMillis() - startTime) + " MilliSeconds");
    }

    private static void sumSequentialStreams() {
        long startTime = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 100000).sum();
        System.out.println(sum);
        System.out.println("Seq Operation took " + (System.currentTimeMillis() - startTime) + " MilliSeconds");
    }

    private static void getHobbiesOfStudentsParallel() {
        long startTime = System.currentTimeMillis();
        Set<String> stringList = StudentUtils.getStudentList().stream()
                .parallel()
                .map(Student::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println(stringList);
        System.out.println("Parallel Operation took " + (System.currentTimeMillis() - startTime) + " MilliSeconds");
    }

    private static void sumParallelStream() {
        long startTime = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 100000).parallel().sum();
        System.out.println(sum);
        System.out.println("Parallel Operation took " + (System.currentTimeMillis() - startTime) + " MilliSeconds");
    }
}

class Sum {
    private long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void performSum(int input) {
        total += input;
    }
}