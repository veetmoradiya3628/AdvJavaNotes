package calenderdatedemo;

import java.time.*;
import java.time.temporal.TemporalUnit;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        Month m = ldt.getMonth();
        System.out.println(m);

        LocalDate date1 = LocalDate.now();

        LocalDate date2 = LocalDate.of(2014, Month.DECEMBER, 12);

        Period gap = Period.between(date2, date1);
        System.out.println(gap.toTotalMonths());

        LocalTime t1 = LocalTime.now();
        Duration fiveHours = Duration.ofHours(5);
        LocalTime t2 = t1.plus(fiveHours);
        System.out.println("After 5 hrs from now : " + t2);
    }
}
