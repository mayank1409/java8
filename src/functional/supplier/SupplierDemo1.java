package functional.supplier;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo1 {

    public static void main(String[] args) {

        Supplier<Student> studentSupplier = () -> new Student("Mayank", "Madhav", "mayank.madhav@soprasteria.com", Double.valueOf(10),"MALE", 10, Arrays.asList("news", "cricket"));
        Student student = studentSupplier.get();
        System.out.println(student);

        System.out.println();

        Supplier<List<Student>> listSupplier = () -> StudentUtils.getStudentList();
        List<Student> studentList = listSupplier.get();
        studentList.forEach(tempStudent -> System.out.println(tempStudent));
    }
}
