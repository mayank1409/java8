package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

public class FilterMapReduce {
    public static void main(String[] args) {
        int noOfNotebooks = StudentUtils.getStudentList().stream()
                .filter(student -> student.getCgpa() > 9.0)
                .filter(student -> student.getFirstName().startsWith("S"))
                .map(Student::getNotebooks)
                .reduce(0, Integer::sum);
        System.out.println(noOfNotebooks);
    }
}
