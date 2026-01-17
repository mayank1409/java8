package functional.function;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 * Demonstrates BiFunction usage with two input parameters.
 * Shows filtering students using Predicate and mapping to grade map.
 */
public class BiFunctionTransformationDemo {

    public static void main(String[] args) {
        // BiFunction: Takes student list and predicate, returns grade map
        BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> createGradeMap =
            (students, predicate) -> {
                Map<String, Double> gradesMap = new HashMap<>();
                students.stream()
                    .filter(predicate)
                    .forEach(student -> gradesMap.put(
                        student.getFirstName() + " " + student.getLastName(),
                        student.getCgpa()
                    ));
                return gradesMap;
            };

        // Define predicate: Students with CGPA > 7.0
        Predicate<Student> minimumCgpaPredicate = student -> student.getCgpa() > 7.0;
        
        System.out.println("Students with CGPA > 7.0:");
        Map<String, Double> result = createGradeMap.apply(
            StudentUtils.getStudentList(),
            minimumCgpaPredicate
        );
        result.forEach((name, cgpa) -> System.out.println(name + ": " + cgpa));
    }
}
