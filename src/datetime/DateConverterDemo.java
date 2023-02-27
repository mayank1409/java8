package datetime;

import java.time.*;
import java.util.Date;

public class DateConverterDemo {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2019, 01, 01);
        System.out.println(date.atTime(12, 23));

        LocalTime time = LocalTime.of(23, 59);
        System.out.println(time.atDate(date));

        LocalDateTime dateTime = time.atDate(date);

        System.out.println(dateTime.toLocalDate());
        System.out.println(dateTime.toLocalTime());

        System.out.println(new Date());

        System.out.println(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

        LocalDate localDate = LocalDate.of(2019, 02, 01);

        System.out.println(new Date().from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant()));

        java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.now());
        System.out.println(sqlDate);

        System.out.println(sqlDate.toLocalDate());
    }
}
