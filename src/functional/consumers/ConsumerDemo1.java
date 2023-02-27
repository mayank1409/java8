package functional.consumers;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo1 {

    private static Consumer<Student> studentConsumer = (student) -> System.out.println(student);
    private static Consumer<Student> studentHobbiesConsumer = (student) -> System.out.println(student.getHobbies());
    private static Consumer<Student> studentNameConsumer = (student) -> System.out.println(student.getFirstName() + " " + student.getLastName());


    public static void main(String[] args) {

        Consumer<String> stringConsumer = (message) -> System.out.println(message);
        stringConsumer.accept("Hello, World!");

        BiConsumer<String, String> stringBiConsumer = (message, name) -> System.out.println(message+ ", "+name);
        stringBiConsumer.accept("hello", "default");

        List<Student> studentList = StudentUtils.getStudentList();

        printStudents(studentList);
        System.out.println();

        printNames(studentList);
        System.out.println();

        printNamesAndHobbies(studentList);
        System.out.println();

        printNameAndHobbiesWithCGPAGE(studentList, 8.0);
        System.out.println();

        printNameAndHobbiesWithCGPAGEAndHobbiesIn(studentList, 7.0, Arrays.asList("swimming", "news", "Tennis"));
        System.out.println();

    }

    private static void printNames(List<Student> studentList) {
        studentList.stream().forEach(studentNameConsumer);
    }

    private static void printStudents(List<Student> studentList) {
        studentList.stream().forEach(studentConsumer);
    }

    private static void printNamesAndHobbies(List<Student> studentList) {
        studentList.stream().forEach(studentNameConsumer.andThen(studentHobbiesConsumer));
    }

    private static void printNameAndHobbiesWithCGPAGE(List<Student> studentList, Double cgpa) {
        studentList.stream().forEach(student -> {
            if (student.getCgpa() > cgpa) {
                studentNameConsumer.andThen(studentHobbiesConsumer).accept(student);
            }
        });
    }

    private static void printNameAndHobbiesWithCGPAGEAndHobbiesIn(List<Student> studentList, Double cgpa, List<String> hobbies) {
        studentList.stream().forEach(student -> {
            if (student.getCgpa() > cgpa && hobbies.containsAll(student.getHobbies())) {
                studentNameConsumer.andThen(studentHobbiesConsumer).accept(student);
            }
        });
    }
}

