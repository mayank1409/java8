package datetime;

import java.time.*;

public class ZonedDateTimeDemo1 {

    public static void main(String[] args) {

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.getOffset());
        System.out.println(zonedDateTime.getZone());

        ZoneId.getAvailableZoneIds().stream().filter(zone -> zone.startsWith("A")).forEach(zone -> System.out.println(zone));
        System.out.println(ZoneId.getAvailableZoneIds().size());

        System.out.println(ZonedDateTime.now(ZoneId.of("America/Chicago")));
        System.out.println(ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
        System.out.println(ZonedDateTime.now(ZoneId.of("America/Denver")));
        System.out.println(ZonedDateTime.now());

        System.out.println(ZonedDateTime.now(Clock.systemDefaultZone()));
        System.out.println(ZonedDateTime.now(Clock.system(ZoneId.of("America/Los_Angeles"))));

        System.out.println("America/Detroit " + LocalDateTime.now(ZoneId.of("America/Detroit")));
        System.out.println("America/Los_Angeles " + LocalDateTime.now(Clock.system(ZoneId.of("America/Los_Angeles"))));

        System.out.println(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.println(LocalDateTime.now().atZone(ZoneId.of("America/Chicago")));

        System.out.println(Instant.now().atZone(ZoneId.of("America/Los_Angeles")));

        OffsetDateTime offsetDateTime = LocalDateTime.now().atOffset(ZoneOffset.ofHours(-6));
        System.out.println(offsetDateTime);
    }
}
