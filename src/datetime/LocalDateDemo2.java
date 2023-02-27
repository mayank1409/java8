package datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateDemo2 {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println("Current date " + localDate);

        LocalDate date = LocalDate.of(2023, 2, 28);
        System.out.println("Random date " + date);

        LocalDate date2 = LocalDate.of(2023, Month.FEBRUARY, 28);
        System.out.println("Another date " + date2);

        LocalDate dateOfYearDay = LocalDate.ofYearDay(2023, 365);
        System.out.println("Random Month " + dateOfYearDay.getMonth());
        System.out.println("Random Month value " + dateOfYearDay.getMonthValue());
        System.out.println("day of week " + dateOfYearDay.getDayOfWeek());
        System.out.println("day of year " + dateOfYearDay.getDayOfYear());

        System.out.println("Day of Month " + dateOfYearDay.get(ChronoField.DAY_OF_MONTH));

        System.out.println("plus days 2 from current date " + localDate.plusDays(2));
        System.out.println("plus months 2 from current date " + localDate.plusMonths(2));
        System.out.println("minus days 2 from current date " + localDate.minusDays(2));
        System.out.println("minus months 2 from current date " + localDate.minusMonths(2));

        System.out.println("with year 2019 " + localDate.withYear(2019));
        System.out.println("with month of year 10 " + localDate.with(ChronoField.MONTH_OF_YEAR, 10));

        System.out.println("firstDayOfNextMonth " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));

        System.out.println("minusYears by 1 " + localDate.minusYears(1));

        System.out.println("local date minus 1 years " + localDate.minus(1, ChronoUnit.YEARS));

        System.out.println("is 2020 a leap year " + LocalDate.ofYearDay(2020, 1).isLeapYear());

        System.out.println("date and date2 equals " + date.isEqual(date2));
        System.out.println("date2 before date " + date2.isBefore(date));
        System.out.println("date 2 after date " + date2.isAfter(date));

        System.out.println(localDate.isSupported(ChronoUnit.MINUTES));
        System.out.println(localDate.isSupported(ChronoUnit.YEARS));
    }
}
