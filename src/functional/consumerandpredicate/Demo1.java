package functional.consumerandpredicate;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Demo1 {

    private static Predicate<Student> studentPredicate = student -> student.getCgpa() > 9.0;

    private static BiConsumer<String, List<String>> biConsumer = (name, hobbies) -> System.out.println(name + " " + hobbies);

    private static Consumer<Student> studentConsumer = student -> {
        if (studentPredicate.test(student)) {
            biConsumer.accept(student.getFirstName()+ " " + student.getLastName(), student.getHobbies());
        }
    };

    public static void main(String[] args) {
        printNameAndHobbies();
    }

    public static void printNameAndHobbies() {
        List<Student> studentList = StudentUtils.getStudentList();
        studentList.forEach(studentConsumer);
    }
}
