package calenderdatedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;

public class CalenderTest {
    public static void main(String[] args) throws ParseException {
        Calendar calendar = new GregorianCalendar(1988, 1, 28, 13, 24, 56);
        System.out.println(calendar);

        Calendar c1 = new GregorianCalendar();
        System.out.println(c1);

        System.out.println(c1.get(Calendar.YEAR));
        System.out.println(c1.get(Calendar.MILLISECOND));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
        System.out.println(sdf.format(calendar.getTime()));

        sdf = new SimpleDateFormat("yy M dd HH:mm:ss", Locale.US);
        System.out.println(sdf.format(c1.getTime()));

        Date d1 = new Date();
        System.out.println(d1);

        System.out.println(sdf.format(d1));

        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(sdf.format(d1));

        sdf.setTimeZone(TimeZone.getTimeZone(ZoneId.of("+1")));
        System.out.println(sdf.format(d1));

        System.out.println("*".repeat(10));
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
