package streams;

import functional.utils.Student;
import functional.utils.StudentUtils;

/**
 * Demonstrates filter-map-reduce pattern using streams.
 * Filters students by CGPA and name, maps to notebooks, then reduces to sum.
 */
public class FilterMapReduce {
    
    public static void main(String[] args) {
        // Filter: CGPA > 9.0 AND name starts with "S"
        // Map: extract notebooks
        // Reduce: sum all notebooks
        int totalNotebooks = StudentUtils.getStudentList().stream()
                .filter(student -> student.getCgpa() > 9.0)
                .filter(student -> student.getFirstName().startsWith("S"))
                .map(Student::getNotebooks)
                .reduce(0, Integer::sum);
        
        System.out.println("Total notebooks for top performers starting with 'S': " + totalNotebooks);
    }
}
