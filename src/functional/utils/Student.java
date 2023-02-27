package functional.utils;

import optional.Bike;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private Double cgpa;
    private String gender;
    List<String> hobbies;
    private int notebooks;
    private Optional<Bike> bike = Optional.empty();

    public Student(String firstName, String lastName, String email, Double cgpa, String gender, int notebooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cgpa = cgpa;
        this.gender = gender;
        this.notebooks = notebooks;
    }

    public Student(String firstName, String lastName, String email, Double cgpa, String gender, int notebooks, List<String> hobbies) {
        this(firstName, lastName, email, cgpa, gender, notebooks);
        this.hobbies = hobbies;
    }

    public Student() {

    }

    public Student(String name) {
        this.firstName = name;
    }

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

    public void printHobbies() {
        System.out.println(hobbies);
    }

    public Optional<Bike> getBike() {
        return bike;
    }

    public void setBike(Optional<Bike> bike) {
        this.bike = bike;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("email='" + email + "'")
                .add("cgpa=" + cgpa)
                .add("hobbies=" + hobbies)
                .toString();
    }
}
