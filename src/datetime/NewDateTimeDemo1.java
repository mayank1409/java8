package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateTimeDemo1 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("Current date " + localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("Current time " + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Current date and time " + localDateTime);
    }
}
