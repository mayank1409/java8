package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.stream.Collectors;

public class LimitsAndSkipDemo {

    public static void main(String[] args) {

        System.out.println(StudentUtils.getStudentList().stream()
                .skip(2)
                .limit(2)
                .map(Student::getFirstName)
                .collect(Collectors.toList()));

    }
}
