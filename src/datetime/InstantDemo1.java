package datetime;

import java.time.Duration;
import java.time.Instant;

public class InstantDemo1 {

    public static void main(String[] args) {
        // Get current instant
        Instant now = Instant.now();
        System.out.println("Current Instant: " + now);

        // Get epoch seconds from instant
        long epochSecond = now.getEpochSecond();
        System.out.println("Epoch seconds: " + epochSecond);

        // Create instant from epoch seconds (Unix epoch: 1970-01-01)
        Instant epochStart = Instant.ofEpochSecond(0);
        System.out.println("Unix Epoch: " + epochStart);

        // Calculate duration between two instants
        Duration duration = Duration.between(epochStart, now);
        System.out.println("Duration since epoch (millis): " + duration.toMillis());
    }
}
