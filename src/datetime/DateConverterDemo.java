package datetime;

import java.time.*;
import java.util.Date;

public class DateConverterDemo {

    public static void main(String[] args) {
        // Convert between LocalDate/LocalTime and LocalDateTime
        LocalDate date = LocalDate.of(2019, 1, 1);
        System.out.println("LocalDate with time: " + date.atTime(12, 23));

        LocalTime time = LocalTime.of(23, 59);
        System.out.println("LocalTime with date: " + time.atDate(date));

        LocalDateTime dateTime = time.atDate(date);
        System.out.println("LocalDateTime to LocalDate: " + dateTime.toLocalDate());
        System.out.println("LocalDateTime to LocalTime: " + dateTime.toLocalTime());

        // Convert between java.util.Date and Java 8 date/time
        System.out.println("Current Date: " + new Date());
        System.out.println("Date as LocalDateTime: " + 
            new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

        // Convert LocalDate/LocalTime to java.util.Date
        LocalDate localDate = LocalDate.of(2019, 2, 1);
        Date convertedDate = Date.from(
            localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDateTime as Date: " + convertedDate);

        // Convert between java.sql.Date and LocalDate
        java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.now());
        System.out.println("SQL Date: " + sqlDate);
        System.out.println("SQL Date as LocalDate: " + sqlDate.toLocalDate());
    }
}
