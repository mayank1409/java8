package datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationDemo1 {

    public static void main(String[] args) {
        // Create Duration from hours
        Duration twoHours = Duration.ofHours(2);
        System.out.println("2 hours in seconds: " + twoHours.getSeconds());

        // Calculate Duration between two times
        LocalTime time1 = LocalTime.of(12, 0, 0);
        LocalTime time2 = LocalTime.of(22, 0, 0);
        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration in hours: " + duration.toHours());
        System.out.println("Duration in minutes: " + duration.toMinutes());

        // Using until method with ChronoUnit
        long hoursUntil = time1.until(time2, ChronoUnit.HOURS);
        System.out.println("Hours until time2: " + hoursUntil);

        // Create Duration from specific units
        Duration threeHours = Duration.ofHours(3);
        System.out.println("3 hours in minutes: " + threeHours.toMinutes());

        Duration threeMinutes = Duration.ofMinutes(3);
        System.out.println("3 minutes in millis: " + threeMinutes.toMillis());
    }
}
