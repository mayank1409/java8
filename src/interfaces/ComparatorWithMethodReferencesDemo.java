package interfaces;

import functional.utils.Student;
import functional.utils.StudentUtils;

import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates sorting using Comparator with method references.
 * Shows sorting by single field and multiple fields using comparator composition.
 */
public class ComparatorWithMethodReferencesDemo {

    public static void main(String[] args) {
        List<Student> students = StudentUtils.getStudentList();
        
        sortAndDisplayByName(students);
        sortAndDisplayByCgpa(students);
        sortAndDisplayByMultipleCriteria(students);
    }

    /**
     * Sort students by first name and display before and after.
     */
    private static void sortAndDisplayByName(List<Student> students) {
        System.out.println("\n===== Sort by Name (A-Z) =====");
        System.out.println("Before sorting:");
        students.forEach(s -> System.out.println("  " + s.getFirstName()));
        
        students.sort(Comparator.comparing(Student::getFirstName));
        System.out.println("After sorting:");
        students.forEach(s -> System.out.println("  " + s.getFirstName()));
    }

    /**
     * Sort students by CGPA and display before and after.
     */
    private static void sortAndDisplayByCgpa(List<Student> students) {
        System.out.println("\n===== Sort by CGPA (ascending) =====");
        System.out.println("Before sorting:");
        students.forEach(s -> System.out.println("  " + s.getCgpa()));
        
        students.sort(Comparator.comparingDouble(Student::getCgpa));
        System.out.println("After sorting:");
        students.forEach(s -> System.out.println("  " + s.getCgpa()));
    }

    /**
     * Sort students by CGPA and then by number of notebooks (composite sorting).
     */
    private static void sortAndDisplayByMultipleCriteria(List<Student> students) {
        System.out.println("\n===== Sort by CGPA, then Notebooks =====");
        System.out.println("Before sorting (CGPA, Notebooks):");
        students.forEach(s -> System.out.println("  " + s.getCgpa() + ", " + s.getNotebooks()));
        
        // Composite comparator: first by CGPA, then by notebooks
        students.sort(Comparator.comparingDouble(Student::getCgpa)
                                 .thenComparingInt(Student::getNotebooks));
        System.out.println("After sorting (CGPA, Notebooks):");
        students.forEach(s -> System.out.println("  " + s.getCgpa() + ", " + s.getNotebooks()));
    }
}
