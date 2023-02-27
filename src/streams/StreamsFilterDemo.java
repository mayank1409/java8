package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterDemo {

    public static void main(String[] args) {

        List<Student> studentList = StudentUtils.getStudentList();

        System.out.println(studentList.stream()
                .filter(student -> student.getFirstName().startsWith("S"))
                .map(Student::getFirstName)
                .collect(Collectors.toList()));

        System.out.println(studentList.stream()
                .filter(student -> student.getFirstName().startsWith("S"))
                .filter(student -> student.getCgpa()>9.0)
                .map(Student::getFirstName)
                .collect(Collectors.toList()));
    }
}
