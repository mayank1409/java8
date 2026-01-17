package datetime;

import java.time.*;

/**
 * Demonstrates ZonedDateTime: date-time with timezone information and conversions.
 */
public class ZonedDateTimeWithTimezoneDemo {

    public static void main(String[] args) {
        // Get current ZonedDateTime
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("Current ZonedDateTime: " + now);
        System.out.println("Zone offset: " + now.getOffset());
        System.out.println("Zone ID: " + now.getZone());

        // Explore available zones
        System.out.println("\nAvailable zones starting with 'A':");
        ZoneId.getAvailableZoneIds().stream()
            .filter(zone -> zone.startsWith("A"))
            .limit(5)  // Limit output for readability
            .forEach(System.out::println);
        System.out.println("Total available zones: " + ZoneId.getAvailableZoneIds().size());

        // ZonedDateTime with different zones
        System.out.println("\nCurrent time in different zones:");
        System.out.println("America/Chicago: " + ZonedDateTime.now(ZoneId.of("America/Chicago")));
        System.out.println("America/Los_Angeles: " + ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
        System.out.println("America/Denver: " + ZonedDateTime.now(ZoneId.of("America/Denver")));
        System.out.println("System default: " + ZonedDateTime.now());

        // Using Clock
        System.out.println("\nUsing Clock:");
        System.out.println("System default clock: " + ZonedDateTime.now(Clock.systemDefaultZone()));
        System.out.println("Los Angeles clock: " + ZonedDateTime.now(Clock.system(ZoneId.of("America/Los_Angeles"))));

        // LocalDateTime with timezone
        System.out.println("\nLocalDateTime with timezone:");
        System.out.println("America/Detroit: " + LocalDateTime.now(ZoneId.of("America/Detroit")));
        System.out.println("America/Los_Angeles: " + LocalDateTime.now(Clock.system(ZoneId.of("America/Los_Angeles"))));

        // Convert Instant to LocalDateTime
        LocalDateTime dateTimeFromInstant = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println("\nInstant as LocalDateTime: " + dateTimeFromInstant);

        // LocalDateTime to ZonedDateTime
        ZonedDateTime chicagoZoned = LocalDateTime.now().atZone(ZoneId.of("America/Chicago"));
        System.out.println("LocalDateTime as Chicago ZonedDateTime: " + chicagoZoned);

        // Instant with timezone
        ZonedDateTime laZoned = Instant.now().atZone(ZoneId.of("America/Los_Angeles"));
        System.out.println("Instant as Los Angeles ZonedDateTime: " + laZoned);

        // OffsetDateTime
        OffsetDateTime offsetDateTime = LocalDateTime.now().atOffset(ZoneOffset.ofHours(-6));
        System.out.println("\nOffsetDateTime (UTC-6): " + offsetDateTime);
    }
}
