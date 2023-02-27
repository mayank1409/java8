package methodref;

import functional.utils.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class Demo2 {

    public static void main(String[] args) {

        Supplier<Student> studentSupplier = Student::new;
        Student student = studentSupplier.get();
        System.out.println(student);

        Function<String, Student> studentFunction = Student::new;
        System.out.println(studentFunction.apply("abc"));
    }
}
