package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class StreamsPartitioningDemo {

    public static void main(String[] args) {
        Map<Boolean, List<Student>> collect = StudentUtils.getStudentList().stream()
                .collect(Collectors.partitioningBy(student -> student.getCgpa() > 9));
        System.out.println(collect);

        Map<Boolean, Set<Student>> collect2 = StudentUtils.getStudentList().stream()
                .collect(Collectors.partitioningBy(student -> student.getCgpa() > 9, toSet()));
        System.out.println(collect2);
    }
}
