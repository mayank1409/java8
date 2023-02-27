package datetime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationDemo1 {

    public static void main(String[] args) {

        Duration twoHours = Duration.ofHours(2);
        System.out.println(twoHours.getSeconds());

        LocalTime time1 = LocalTime.of(12, 00, 00);
        LocalTime time2 = LocalTime.of(22, 00, 00);
        Duration duration = Duration.between(time1, time2);
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());


        long until = time1.until(time2, ChronoUnit.HOURS);
        System.out.println(until);

        Duration durationOf3Hours = Duration.ofHours(3);
        System.out.println(durationOf3Hours.toMinutes());

        Duration durationOf3Minutes = Duration.ofMinutes(3);
        System.out.println(durationOf3Minutes.toMillis());

    }
}
