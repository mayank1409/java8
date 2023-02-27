package functional.function;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionDemo1 {

    public static void main(String[] args) {

        BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = ((students, studentPredicate) -> {
            Map<String, Double> gradesMap = new HashMap<>();
            students.forEach(student -> {
                if (studentPredicate.test(student)) {
                    gradesMap.put(student.getFirstName()+student.getLastName(), student.getCgpa());
                }
            });
            return gradesMap;
        });

        Predicate<Student> studentPredicate = student -> student.getCgpa() > 7.0;
        Map<String, Double> gradesMap = biFunction.apply(StudentUtils.getStudentList(), studentPredicate);
        System.out.println(gradesMap);

    }
}
