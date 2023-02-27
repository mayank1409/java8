package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamsMappingDemo {

    public static void main(String[] args) {
        List<String> nameList = StudentUtils.getStudentList().stream()
                .collect(mapping(Student::getFirstName, toList()));
        System.out.println(nameList);

        Set<String> nameSet = StudentUtils.getStudentList().stream()
                .collect(mapping(Student::getFirstName, toSet()));
        System.out.println(nameSet);


    }
}
