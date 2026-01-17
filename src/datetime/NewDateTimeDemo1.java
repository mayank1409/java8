package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateTimeDemo1 {

    public static void main(String[] args) {
        // Get current date
        LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        // Get current time
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);

        // Get current date and time combined
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + currentDateTime);
    }
}
