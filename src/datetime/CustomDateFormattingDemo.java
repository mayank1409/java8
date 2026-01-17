package datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Demonstrates custom date formatting with DateTimeFormatter patterns and parsing.
 */
public class CustomDateFormattingDemo {

    /**
     * Parse date string using appropriate formatter based on format pattern
     */
    public static LocalDate parse(String dateString) {
        if (dateString.contains("-")) {
            return LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
        } else if (dateString.contains("|")) {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy|MM|dd"));
        } else if (dateString.contains("*")) {
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy*MM*dd"));
        } else {
            return LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE);
        }
    }

    /**
     * Format LocalDate using provided DateTimeFormatter
     */
    public static String format(LocalDate localDate, DateTimeFormatter formatter) {
        return localDate.format(formatter);
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        
        System.out.println("Parse ISO Date: " + parse("2023-09-14"));
        System.out.println("Parse Basic ISO Date: " + parse("20230914"));
        System.out.println("Parse Pipe Separator: " + parse("2023|09|14"));
        System.out.println("Parse Asterisk Separator: " + parse("2023*09*14"));
        
        System.out.println("Format with asterisk: " + format(now, DateTimeFormatter.ofPattern("yyyy*MM*dd")));
        System.out.println("Format ISO Date: " + format(now, DateTimeFormatter.ISO_DATE));
        System.out.println("Format Basic ISO Date: " + format(now, DateTimeFormatter.BASIC_ISO_DATE));
    }
}
