package optional;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Optional;


public class OptionalDemo {

    public static String getStudentName() {
        Optional<Student> optional = Optional.ofNullable(StudentUtils.studentSupplier2.get());
        return optional.map(Student::getFirstName).orElseGet(() ->"Default");
    }

    public static Optional<String> getLength() {
        return Optional.ofNullable("Hello, World");
    }

    public static void main(String[] args) {
        System.out.println("Length of Name : " + getStudentName() + " is " + getStudentName().length());

        if (getLength().isPresent()) {
            System.out.println("Length = " + getLength().get().length());
        } else {
            System.out.println("Length = 0");
        }

        Optional<String> s = Optional.of("Hello, World");
        if (s.isPresent()) {
            System.out.println(s.get().toUpperCase());
        }

        Optional<Object> empty = Optional.empty();
        if (empty.isEmpty()) {
            System.out.println("Object is empty!");
        }

        Optional<Student> student = Optional.ofNullable(StudentUtils.studentSupplier.get());
        String name = student.map(Student::getFirstName).orElse("Default");
        System.out.println(name);

        Optional<Student> student3 = Optional.ofNullable(StudentUtils.studentSupplier2.get());
        String name3 = student3.map(Student::getFirstName).orElseGet(()-> "Default");
        System.out.println(name3);

        Optional<Student> optionalStudent = Optional.ofNullable(StudentUtils.studentSupplier.get());
        optionalStudent.filter(tempStudent -> tempStudent.getFirstName().length() > 4).ifPresent(tempStudent -> System.out.println(tempStudent.getCgpa()));

        Optional<Student> optionalStudent2 = Optional.ofNullable(StudentUtils.studentSupplier2.get());
        if (optionalStudent2.isPresent()) {
            System.out.println(optionalStudent2.map(Student::getFirstName).get());
        }

        Optional<Student> optionalStudent3 = Optional.ofNullable(StudentUtils.studentSupplier.get());
        optionalStudent3.flatMap(Student::getBike).ifPresent(System.out::println);
    }
}