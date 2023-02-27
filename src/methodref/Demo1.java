package methodref;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.function.Consumer;
import java.util.function.Function;

public class Demo1 {

    static Function<String, String> stringFunction = s -> s.toUpperCase();

    static Function<String, String> stringFunctionMethodRef = String::toUpperCase;

    static Consumer<String> stringConsumer = System.out::println;

    static Consumer<Student> studentConsumer = Student::printHobbies;

    public static void main(String[] args) {
        String result = stringFunction.apply("java8");
        System.out.println(result);

        String helloJava8 = stringFunctionMethodRef.apply("hello java8");
        System.out.println(helloJava8);

        stringConsumer.accept(stringFunctionMethodRef.apply("hello java 8"));

        StudentUtils.getStudentList().forEach(studentConsumer);

    }
}
