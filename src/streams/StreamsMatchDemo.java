package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

public class StreamsMatchDemo {

    public static void main(String[] args) {

        boolean allMatch = StudentUtils.getStudentList().stream()
                .allMatch(student -> student.getCgpa() > 9);
        System.out.println(allMatch);

        boolean noneMatch = StudentUtils.getStudentList().stream()
                .noneMatch(student -> student.getCgpa() > 9);
        System.out.println(noneMatch);

        boolean anyMatch = StudentUtils.getStudentList().stream()
                .anyMatch(student -> student.getCgpa() > 9);
        System.out.println(anyMatch);

        System.out.println(StudentUtils.getStudentList().stream()
                .filter(student -> student.getCgpa() > 9)
                .findFirst()
                .map(Student::getFirstName).get());

        System.out.println(StudentUtils.getStudentList().stream()
                .filter(student -> student.getCgpa() > 9)
                .findAny()
                .map(Student::getFirstName).get());
    }
}
