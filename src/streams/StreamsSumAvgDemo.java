package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

public class StreamsSumAvgDemo {

    public static void main(String[] args) {
        Integer integer = StudentUtils.getStudentList().stream()
                .collect(summingInt(Student::getNotebooks));
        System.out.println(integer);

        Double aDouble = StudentUtils.getStudentList().stream()
                .collect(averagingInt(Student::getNotebooks));
        System.out.println(aDouble);
    }
}
