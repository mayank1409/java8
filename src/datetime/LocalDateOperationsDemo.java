package datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Demonstrates LocalDate operations: temporal queries, field access, adjusters, and arithmetic.
 */
public class LocalDateOperationsDemo {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("Current date: " + now);

        // Create LocalDate instances
        LocalDate date1 = LocalDate.of(2023, 2, 28);
        System.out.println("Date with int month: " + date1);

        LocalDate date2 = LocalDate.of(2023, Month.FEBRUARY, 28);
        System.out.println("Date with Month enum: " + date2);

        // Create LocalDate from year-day
        LocalDate yearDay = LocalDate.ofYearDay(2023, 365);
        System.out.println("Month: " + yearDay.getMonth());
        System.out.println("Month value (1-12): " + yearDay.getMonthValue());
        System.out.println("Day of week: " + yearDay.getDayOfWeek());
        System.out.println("Day of year: " + yearDay.getDayOfYear());
        System.out.println("Day of month: " + yearDay.get(ChronoField.DAY_OF_MONTH));

        // Date arithmetic
        System.out.println("\nDate Arithmetic:");
        System.out.println("Plus 2 days: " + now.plusDays(2));
        System.out.println("Plus 2 months: " + now.plusMonths(2));
        System.out.println("Minus 2 days: " + now.minusDays(2));
        System.out.println("Minus 2 months: " + now.minusMonths(2));
        System.out.println("Minus 1 year: " + now.minusYears(1));
        System.out.println("Minus 1 year (ChronoUnit): " + now.minus(1, ChronoUnit.YEARS));

        // Date manipulation
        System.out.println("\nDate Manipulation:");
        System.out.println("With year 2019: " + now.withYear(2019));
        System.out.println("With month 10: " + now.with(ChronoField.MONTH_OF_YEAR, 10));
        System.out.println("First day of next month: " + now.with(TemporalAdjusters.firstDayOfNextMonth()));

        // Date comparisons and queries
        System.out.println("\nDate Comparisons:");
        System.out.println("date1 equals date2: " + date1.isEqual(date2));
        System.out.println("date2 is before date1: " + date2.isBefore(date1));
        System.out.println("date2 is after date1: " + date2.isAfter(date1));
        System.out.println("Is 2020 a leap year: " + LocalDate.ofYearDay(2020, 1).isLeapYear());

        // Temporal unit support
        System.out.println("\nTemporal Unit Support:");
        System.out.println("Supports MINUTES: " + now.isSupported(ChronoUnit.MINUTES));
        System.out.println("Supports YEARS: " + now.isSupported(ChronoUnit.YEARS));
    }
}
