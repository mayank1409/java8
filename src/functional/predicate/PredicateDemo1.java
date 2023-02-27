package functional.predicate;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo1 {

    private static final Predicate<Integer> evenPredicate = i -> i % 2 == 0;
    private static final Predicate<Integer> divisibleBy5 = i -> i % 5 == 0;
    private static final Predicate<Student> cgpaGE7 = student -> student.getCgpa() > 7.0;
    private static final List<String> HOBBIES = Arrays.asList("swimming", "news", "Tennis");
    private static final Predicate<Student> hobbiesPredicate = student -> HOBBIES.containsAll(student.getHobbies());

    public static void main(String[] args) {

        boolean b = evenPredicate.test(10);
        System.out.println(b);

        boolean b1 = divisibleBy5.and(evenPredicate).test(12);
        System.out.println(b1);

        boolean b2 = divisibleBy5.or(evenPredicate).test(12);
        System.out.println(b2);

        boolean b3 = divisibleBy5.or(evenPredicate).negate().test(12);
        System.out.println(b3);


        List<Student> studentList = StudentUtils.getStudentList();

        studentList.forEach(student -> {
            if (cgpaGE7.and(hobbiesPredicate).test(student)) {
                System.out.println(student);
            }
        });


    }
}
