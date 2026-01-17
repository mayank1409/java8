package functional.utils;

import optional.Bike;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * Student POJO representing a student with personal and academic information.
 */
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Double cgpa;  // Cumulative Grade Point Average
    private String gender;
    private List<String> hobbies;
    private int notebooks;
    private Optional<Bike> bike;

    /**
     * Full constructor with all required fields.
     */
    public Student(String firstName, String lastName, String email, Double cgpa, String gender, int notebooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cgpa = cgpa;
        this.gender = gender;
        this.notebooks = notebooks;
        this.bike = Optional.empty();
    }

    /**
     * Extended constructor including hobbies.
     */
    public Student(String firstName, String lastName, String email, Double cgpa, String gender, int notebooks, List<String> hobbies) {
        this(firstName, lastName, email, cgpa, gender, notebooks);
        this.hobbies = hobbies;
    }

    /**
     * Default constructor.
     */
    public Student() {
        this.bike = Optional.empty();
    }

    /**
     * Constructor with name only.
     */
    public Student(String name) {
        this.firstName = name;
        this.bike = Optional.empty();
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public int getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(int notebooks) {
        this.notebooks = notebooks;
    }

    public Optional<Bike> getBike() {
        return bike;
    }

    public void setBike(Optional<Bike> bike) {
        this.bike = bike;
    }

    /**
     * Print student's hobbies.
     */
    public void printHobbies() {
        System.out.println(hobbies);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("email='" + email + "'")
                .add("cgpa=" + cgpa)
                .add("gender='" + gender + "'")
                .add("hobbies=" + hobbies)
                .toString();
    }
}
