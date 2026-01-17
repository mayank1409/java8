package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * Demonstrates reduce() terminal operation.
 * Shows reducing to single value using accumulators and binary operators.
 */
public class StreamReduceDemo {

    public static void main(String[] args) {
        // Reduce integers using multiplication
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7);
        int product = numbers.stream()
                .reduce((a, b) -> a * b)
                .get();
        System.out.println("Product of numbers: " + product);

        // Reduce students to find highest CGPA
        Student topStudent = StudentUtils.getStudentList().stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparing(Student::getCgpa)))
                .get();
        System.out.println("Student with highest CGPA: " + topStudent.getFirstName() + " (" + topStudent.getCgpa() + ")");
    }
}
