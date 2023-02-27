package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsMapDemo {

    public static void main(String[] args) {
        List<Student> studentList = StudentUtils.getStudentList();

        List<String> names = studentList.stream()
                .map(student -> student.getFirstName() + " " + student.getLastName())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(names);

        Set<String> hobbiesSet = studentList.stream()
                .map(Student::getHobbies)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println(hobbiesSet);

        long uniqueHobbies = studentList.stream()
                .map(Student::getHobbies)
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println("uniqueHobbies: " + uniqueHobbies);

        List<String> hobbies = Arrays.asList("swimming", "news", "Tennis");

        long answer = studentList.stream()
                .map(Student::getHobbies)
                .filter(hobby -> hobbies.containsAll(hobby)).count();
        System.out.println(answer);


        List<String> sortedStudents = studentList.stream()
                .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName))
                .map(Student::getFirstName)
                .collect(Collectors.toList());
        System.out.println("students sorted by name: "+sortedStudents);

        List<String> sortedStudentsByCgpa = studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getCgpa).reversed())
                .map(Student::getFirstName)
                .collect(Collectors.toList());
        System.out.println("students sorted by cgpa: "+sortedStudentsByCgpa);
    }
}
