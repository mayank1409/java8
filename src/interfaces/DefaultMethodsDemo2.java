package interfaces;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Comparator;
import java.util.List;

public class DefaultMethodsDemo2 {

    public static void main(String[] args) {
        List<Student> studentList = StudentUtils.getStudentList();
        sortByName(studentList);
        sortByCgpa(studentList);
        sortByCgpaAndNumberOfNotebooks(studentList);
    }

    public static void sortByName(List<Student> studentList) {
        studentList.forEach(s -> System.out.println(s.getFirstName() + " "));
        System.out.println("=================================================");
        studentList.sort(Comparator.comparing(Student::getFirstName));
        System.out.println("=================================================");
        studentList.forEach(s -> System.out.println(s.getFirstName() + " "));
        System.out.println("=================================================");
    }

    public static void sortByCgpa(List<Student> studentList) {
        System.out.println("=================================================");
        studentList.forEach(s -> System.out.println(s.getCgpa() + " "));
        studentList.sort(Comparator.comparingDouble(Student::getCgpa));
        System.out.println("=================================================");
        studentList.forEach(s -> System.out.println(s.getCgpa() + " "));
        System.out.println("=================================================");
    }

    public static void sortByCgpaAndNumberOfNotebooks(List<Student> studentList) {
        System.out.println("=================================================");
        studentList.forEach(s -> System.out.println(s.getCgpa() + " " + s.getNotebooks()));
        studentList.sort(Comparator.comparingDouble(Student::getCgpa).thenComparingInt(Student::getNotebooks));
        System.out.println("=================================================");
        studentList.forEach(s -> System.out.println(s.getCgpa() + " " + s.getNotebooks()));
        System.out.println("=================================================");
    }
}
