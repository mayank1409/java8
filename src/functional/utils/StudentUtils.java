package functional.utils;

import optional.Bike;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Utility class providing Suppliers and helper methods for Student objects.
 */
public class StudentUtils {

    /**
     * Supplier that creates a Student with predefined bike information.
     */
    public static Supplier<Student> studentSupplier = () -> {
        Bike bike = new Bike();
        bike.setModel("MOD123");
        bike.setName("Apache");
        
        Student student = new Student();
        student.setFirstName("Mickey");
        student.setCgpa(8.8);
        student.setBike(Optional.ofNullable(bike));
        return student;
    };

    /**
     * Supplier that returns null (for Optional demonstration).
     */
    public static Supplier<Student> studentSupplier2 = () -> null;

    /**
     * Creates and returns a predefined list of students for testing.
     * @return List of 5 students with various attributes
     */
    public static List<Student> getStudentList() {
        Student student1 = new Student(
            "John", "Doe", "john.doe@luv2code.com", 7.0, "MALE", 11,
            Arrays.asList("swimming", "Tennis"));
        
        Student student2 = new Student(
            "Paul", "Doe", "paul.doe@luv2code.com", 9.2, "MALE", 10,
            Arrays.asList("news", "music"));
        
        Student student3 = new Student(
            "Shaun", "Doe", "shaun.doe@luv2code.com", 7.2, "MALE", 7,
            Arrays.asList("news", "Tennis"));
        
        Student student4 = new Student(
            "Stephen", "Doe", "stephen.doe@luv2code.com", 9.2, "MALE", 6,
            Arrays.asList("news", "dancing"));
        
        Student student5 = new Student(
            "Mick", "Doe", "mick.doe@luv2code.com", 9.8, "MALE", 5,
            Arrays.asList("sports"));

        return Arrays.asList(student1, student2, student3, student4, student5);
    }
}
