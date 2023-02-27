package functional.utils;

import optional.Bike;
import optional.OptionalDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class StudentUtils {

    public static Supplier<Student> studentSupplier = () -> {
        Bike bike = new Bike();
        bike.setModel("MOD123");
        bike.setName("Apache");
        Student student = new Student();
        student.setFirstName("Mickey");
        student.setCgpa(Double.valueOf(8.8));
        student.setBike(Optional.ofNullable(bike));
        return student;
    };

    public static Supplier<Student> studentSupplier2 = () -> null;

    public static List<Student> getStudentList() {
        Student student1 = new Student("John", "Doe", "john.doe@luv2code.com", Double.valueOf(7),"MALE",11, Arrays.asList("swimming", "Tennis"));
        Student student2 = new Student("Paul", "Doe", "paul.doe@luv2code.com", Double.valueOf(9.2),"MALE",10, Arrays.asList("news", "music"));
        Student student3 = new Student("Shaun", "Doe", "shaun.doe@luv2code.com", Double.valueOf(7.2),"MALE", 7, Arrays.asList("news", "Tennis"));
        Student student4 = new Student("Stephen", "Doe", "stephen.doe@luv2code.com", Double.valueOf(9.2),"MALE",6, Arrays.asList("news", "dancing"));
        Student student5 = new Student("Mick", "Doe", "mick.doe@luv2code.com", Double.valueOf(9.8),"MALE", 5, Arrays.asList("sports"));

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4, student5);
        return studentList;
    }

}
