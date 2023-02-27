package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamsGroupingByDemo {

    public static void main(String[] args) {

        Map<String, List<Student>> collect = StudentUtils.getStudentList().stream()
                .collect(groupingBy(Student::getGender));
        System.out.println(collect);

        List<List<String>> list = StudentUtils.getStudentList().stream()
                .map(Student::getHobbies)
                .sorted(Comparator.comparing(List::size))
                .collect(toList());
        System.out.println(list);

        Map<String, List<Student>> map = StudentUtils.getStudentList().stream()
                .collect(groupingBy(student -> student.getCgpa() > 9 ? "OUTSTANDING" : "AVERAGE"));

        List<String> outstandingStudents = map.get("OUTSTANDING").stream().map(Student::getFirstName).collect(Collectors.toList());
        System.out.println(outstandingStudents);

        List<String> averageStudents = map.get("AVERAGE").stream().map(Student::getFirstName).collect(Collectors.toList());
        System.out.println(averageStudents);

        Map<String, Integer> map1 = StudentUtils.getStudentList().stream()
                .collect(groupingBy(Student::getFirstName,
                        summingInt(Student::getNotebooks)));
        System.out.println(map1);

        LinkedHashMap<String, Integer> collect1 = StudentUtils.getStudentList().stream()
                .collect(groupingBy(Student::getFirstName, LinkedHashMap::new,
                        summingInt(Student::getNotebooks)));
        System.out.println(collect1);

        Map<String, Optional<Student>> collect2 = StudentUtils.getStudentList().stream()
                .collect(groupingBy(student -> student.getCgpa() > 9 ? "OUTSTANDING" : "AVERAGE",
                        minBy(Comparator.comparing(Student::getCgpa))));

        System.out.println(collect2.get("OUTSTANDING").get().getFirstName());
        System.out.println(collect2.get("AVERAGE").get().getFirstName());

        Map<String, Student> collect3 = StudentUtils.getStudentList().stream()
                .collect(groupingBy(student -> student.getCgpa() > 9 ? "OUTSTANDING" : "AVERAGE",
                        collectingAndThen(maxBy(Comparator.comparing(Student::getCgpa)), Optional::get)));

        System.out.println(collect3.get("OUTSTANDING").getFirstName());

    }
}
