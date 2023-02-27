package datetime;

import java.time.Duration;
import java.time.Instant;

public class InstantDemo1 {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant);

        long epochSecond = instant.getEpochSecond();
        System.out.println(epochSecond);

        Instant epochSecond1 = Instant.ofEpochSecond(0);
        System.out.println(epochSecond1);

        Instant instant1 = Instant.now();

        Duration duration = Duration.between(epochSecond1, instant1);
        System.out.println(duration.toMillis());
    }
}
