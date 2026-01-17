package datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates Period: date-based amounts in years, months, and days.
 */
public class PeriodCalculationsDemo {

    public static void main(String[] args) {
        // Calculate period between two dates
        LocalDate startDate = LocalDate.of(2019, Month.JANUARY, 1);
        LocalDate endDate = LocalDate.of(2019, Month.DECEMBER, 31);

        Period period = startDate.until(endDate);
        System.out.println("Period between dates:");
        System.out.println("  Months: " + period.get(ChronoUnit.MONTHS));
        System.out.println("  Years: " + period.get(ChronoUnit.YEARS));
        System.out.println("  Days: " + period.get(ChronoUnit.DAYS));

        // Create Period from specific units
        Period tenDays = Period.ofDays(10);
        System.out.println("\n10 days period: " + tenDays.getDays() + " days");

        Period tenYears = Period.ofYears(10);
        System.out.println("10 years period: " + tenYears.getYears() + " years");
        System.out.println("10 years in months: " + tenYears.toTotalMonths() + " months");

        // Using Period.between
        Period periodBetween = Period.between(startDate, endDate);
        System.out.println("\nBetween dates (from Period.between):");
        System.out.println("  Days: " + periodBetween.getDays());
        System.out.println("  Months: " + periodBetween.getMonths());
    }
}
