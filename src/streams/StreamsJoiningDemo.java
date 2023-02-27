package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import static java.util.stream.Collectors.joining;

public class StreamsJoiningDemo {

    public static void main(String[] args) {
        String names = StudentUtils.getStudentList().stream()
                .map(Student::getFirstName)
                .collect(joining());
        System.out.println(names);

        String namesWithDelimiter = StudentUtils.getStudentList().stream()
                .map(Student::getFirstName)
                .collect(joining("-"));
        System.out.println(namesWithDelimiter);

        String namesWithPrefixAndSuffix = StudentUtils.getStudentList().stream()
                .map(Student::getFirstName)
                .collect(joining("-", "{", "}"));
        System.out.println(namesWithPrefixAndSuffix);


    }
}
