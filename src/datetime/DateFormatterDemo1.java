package datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatterDemo1 {

    public static LocalDate parse(String date) {

        LocalDate localDate;
        if (date.contains("-")) {
            localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        } else if (date.contains("|")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
            localDate = LocalDate.parse(date, formatter);
        } else if (date.contains("*")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy*MM*dd");
            localDate = LocalDate.parse(date, formatter);
        } else {
            localDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        }
        return localDate;
    }

    public static String format(LocalDate localDate, DateTimeFormatter formatter) {
        return localDate.format(formatter);
    }

    public static void main(String[] args) {
        System.out.println(parse("2023-09-14"));
        System.out.println(parse("20230914"));
        System.out.println(parse("2023|09|14"));
        System.out.println(parse("2023*09*14"));
        System.out.println(format(LocalDate.now(), DateTimeFormatter.ofPattern("yyyy*MM*dd")));
        System.out.println(format(LocalDate.now(), DateTimeFormatter.ISO_DATE));
        System.out.println(format(LocalDate.now(), DateTimeFormatter.BASIC_ISO_DATE));
    }
}
