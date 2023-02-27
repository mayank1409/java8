package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class StreamsMaxByMinByDemo {

    public static void main(String[] args) {
        Optional<Student> optionalStudent = StudentUtils.getStudentList().stream()
                .collect(maxBy(Comparator.comparing(Student::getCgpa)));
        System.out.println(optionalStudent.get().getFirstName());

        Optional<Student> optionalStudentMin = StudentUtils.getStudentList().stream()
                .collect(minBy(Comparator.comparing(Student::getCgpa)));
        System.out.println(optionalStudentMin.get().getFirstName());


    }
}
