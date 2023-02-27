package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo1 {

    public static void main(String[] args) {
        List<Student> studentList = StudentUtils.getStudentList();

        Predicate<Student> studentCgpaPredicate = student -> student.getCgpa() > 8.0;

        Map<String, List<String>> map = studentList.stream()
                .filter(studentCgpaPredicate)
                .collect(Collectors.toMap(Student::getFirstName, Student::getHobbies));
        System.out.println(map);
    }
}
