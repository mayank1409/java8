package datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo1 {

    public static void main(String[] args) {

        LocalTime currentTime = LocalTime.now();
        System.out.println("current time is " + currentTime);

        LocalTime twelveFortyFive = LocalTime.of(12, 45);
        System.out.println("random time is " + twelveFortyFive);

        LocalTime twelveFortyFiveOne = LocalTime.of(12, 45, 1);
        System.out.println("another random time is " + twelveFortyFiveOne);

        System.out.println("current time hour is " + currentTime.getHour());
        System.out.println("current time minute is " + currentTime.getMinute());

        System.out.println("CLOCK_HOUR_OF_DAY is " + currentTime.get(ChronoField.CLOCK_HOUR_OF_DAY));
        System.out.println("CLOCK_HOUR_OF_AMPM is " + currentTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));

        System.out.println("SecondOfDay is " + currentTime.toSecondOfDay());

        System.out.println("current time plus 12 minutes is " + currentTime.plus(12, ChronoUnit.MINUTES));
        System.out.println("current time plus 12 hours is " + currentTime.plusHours(12));

        System.out.println("MIDNIGHT is " + currentTime.with(LocalTime.MIDNIGHT));
        System.out.println("4 HOUR_OF_DAY is " + currentTime.with(ChronoField.HOUR_OF_DAY, 4));

        System.out.println("plus 30 minutes to current time is " + currentTime.plusMinutes(30));

        System.out.println("time with hour 10 is " + currentTime.withHour(10));
    }
}
