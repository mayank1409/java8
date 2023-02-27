package functional.function;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionDemo1 {

    public static void main(String[] args) {

        Function<Integer, Integer> function = (a) -> a * a;
        System.out.println(function.apply(10));

        Function<String, String> function1 = (s) -> s.toUpperCase();
        System.out.println(function1.apply("java"));

        Function<String, String> function2 = (s) -> s.concat("8");
        System.out.println(function1.andThen(function2).apply("java"));

        System.out.println(function1.compose(function2).apply("java"));


        studentFunction();
    }

    public static void studentFunction() {

        Predicate<Student> studentPredicate = student -> student.getCgpa() > 9.0;

        Function<List<Student>, Map<String, Double>> studentFunction = (students) -> {
            Map<String, Double> gradesMap = new HashMap<>();
            students.forEach(student -> {
                if (studentPredicate.test(student))
                    gradesMap.put(student.getFirstName() + student.getLastName(), student.getCgpa());
            });
            return gradesMap;
        };

        System.out.println(studentFunction.apply(StudentUtils.getStudentList()));
    }
}
