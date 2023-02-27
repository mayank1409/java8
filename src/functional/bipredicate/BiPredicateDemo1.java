package functional.bipredicate;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class BiPredicateDemo1 {

    private static final List<String> HOBBIES = Arrays.asList("swimming", "news", "Tennis");
    private static BiPredicate<Double, List<String>> biPredicate = (cgpa, hobbies) -> cgpa > 7.0 && HOBBIES.containsAll(hobbies);

    private static BiConsumer<String, List<String>> biConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);

    private static Consumer<Student> studentConsumer = student -> {
        if (biPredicate.test(student.getCgpa(), student.getHobbies())) {
            biConsumer.accept(student.getFirstName(), student.getHobbies());
        }
    };

    public static void main(String[] args) {
        namesAndHobbiesUsingCondition();
    }

    private static void namesAndHobbiesUsingCondition() {
        List<Student> studentList = StudentUtils.getStudentList();
        studentList.stream().forEach(studentConsumer);
    }
}
