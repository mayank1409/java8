package datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo1 {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now);

        // Create LocalTime instances
        LocalTime noonQuarter = LocalTime.of(12, 45);
        System.out.println("Time (12:45): " + noonQuarter);

        LocalTime noonQuarterOne = LocalTime.of(12, 45, 1);
        System.out.println("Time (12:45:01): " + noonQuarterOne);

        // Get time components
        System.out.println("\nTime Components:");
        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
        System.out.println("Clock hour of day (1-24): " + now.get(ChronoField.CLOCK_HOUR_OF_DAY));
        System.out.println("Clock hour of AM/PM (1-12): " + now.get(ChronoField.CLOCK_HOUR_OF_AMPM));
        System.out.println("Seconds since midnight: " + now.toSecondOfDay());

        // Time arithmetic
        System.out.println("\nTime Arithmetic:");
        System.out.println("Plus 12 minutes (ChronoUnit): " + now.plus(12, ChronoUnit.MINUTES));
        System.out.println("Plus 12 hours: " + now.plusHours(12));
        System.out.println("Plus 30 minutes: " + now.plusMinutes(30));

        // Time manipulation
        System.out.println("\nTime Manipulation:");
        System.out.println("Set to MIDNIGHT: " + now.with(LocalTime.MIDNIGHT));
        System.out.println("Set to hour 4 (04:00): " + now.with(ChronoField.HOUR_OF_DAY, 4));
        System.out.println("Set to hour 10 (10:MM:SS): " + now.withHour(10));
    }
}
