package methodref;

import functional.utils.Student;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Demonstrates constructor method references.
 * Shows how to reference constructors using :: syntax.
 */
public class Demo2 {

    public static void main(String[] args) {
        // Constructor reference with no parameters using Supplier
        Supplier<Student> defaultConstructor = Student::new;
        Student student1 = defaultConstructor.get();
        System.out.println("Student from default constructor: " + student1);

        // Constructor reference with String parameter using Function
        Function<String, Student> stringConstructor = Student::new;
        Student student2 = stringConstructor.apply("Alice");
        System.out.println("Student from String constructor: " + student2);
    }
}
