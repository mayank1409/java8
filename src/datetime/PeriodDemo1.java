package datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDemo1 {

    public static void main(String[] args) {

        LocalDate date1 = LocalDate.of(2019, Month.JANUARY, 1);
        LocalDate date2 = LocalDate.of(2019, Month.DECEMBER, 31);

        Period period = date1.until(date2);

        System.out.println(period.get(ChronoUnit.MONTHS));
        System.out.println(period.get(ChronoUnit.YEARS));
        System.out.println(period.get(ChronoUnit.DAYS));

        Period tenDays = Period.ofDays(10);
        System.out.println(tenDays.getDays());

        Period tenYears = Period.ofYears(10);
        System.out.println(tenYears.getYears());

        System.out.println(tenYears.toTotalMonths());

        System.out.println(Period.between(date1, date2).getDays());
        System.out.println(Period.between(date1, date2).getMonths());
    }
}
