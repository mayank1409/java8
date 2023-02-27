package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class StreamReduceDemo {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2, 3, 5, 7);

        int mult = integerList.stream().reduce((a, b) -> a * b).get();
        System.out.println(mult);

        Student studentWithHighestCGPA = StudentUtils.getStudentList().stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparing(Student::getCgpa))).get();
        System.out.println(studentWithHighestCGPA.getCgpa());
    }
}
