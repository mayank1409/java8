package functional.consumers;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerDemo1 {
    public static void main(String[] args) {

        BiConsumer<String , String> biConsumer = (a, b) -> System.out.println(a + " " + b);
        biConsumer.accept("hello", "java8");
        System.out.println();

        BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("Multiplication : " + a*b);
        BiConsumer<Integer, Integer> division = (a, b) -> System.out.println("Division : " + a/b);
        multiply.andThen(division).accept(10,5);
        System.out.println();

        List<Student> studentList = StudentUtils.getStudentList();
        nameAndHobbies(studentList);


    }

    private static void nameAndHobbies(List<Student> studentList) {
        BiConsumer<String, List<String>> biConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);
        studentList.forEach(student -> biConsumer.accept(student.getFirstName()+student.getLastName(), student.getHobbies()));
    }
}
