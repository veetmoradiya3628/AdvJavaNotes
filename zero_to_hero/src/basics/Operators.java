package basics;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operators {
    public static void main(String[] args) {
        int i = +10;
        int i2 = -10;
        System.out.println(i);
        System.out.println(i2);

        int i3 = ++i;
        int i4 = i++;

        System.out.println(i3);
        System.out.println(i4);

        int i5 = --i;
        int i6 = i--;
        System.out.println(i5);
        System.out.println(i6);

        BigDecimal rideFee = BigDecimal.valueOf(20).setScale(2);
        System.out.println("rideFee : " + rideFee);

        BigDecimal amountOfPeople = BigDecimal.valueOf(3);
        System.out.println("amountOfPeople : " + amountOfPeople);

        BigDecimal chargePerPerson = rideFee.divide(amountOfPeople, RoundingMode.HALF_UP);
        System.out.println("charge per person : " + chargePerPerson);

        System.out.println(Math.PI);
        System.out.println(Math.max(3,5));
        System.out.println(0/0.0);

        System.out.println(Math.random());
        System.out.println((int)(Math.random() * 100));
        System.out.println(Math.random() * 100);

    }
}
