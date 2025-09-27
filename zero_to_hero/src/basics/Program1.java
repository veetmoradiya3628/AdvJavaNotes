package basics;

public class Program1 {
    public static void main(String[] args) {
        byte b = 1;
        short s;
        s = 2;

        int i = 3;
        long l = 4;

        char c = 'a';

        boolean bool = true;
        float f = 1.2f;
        double d = 1.2;

        var v = 1;
//        v = true;
//        v = 1.3;

        int i3 = s;
        char c2 = 100;
        System.out.println(c2);

        double d3 = i3;
        d3 = l;

        b = (byte) i3;
        byte b2 = (byte) 130;
        System.out.println(b2);

        int dec = 152;
        int bin = 0b10011000;
        int oct = 0230;
        int hex = 0x98;
        System.out.println(dec);
        System.out.println(bin);
        System.out.println(oct);
        System.out.println(hex);

        int age = (int)(Math.random() * 100);
        boolean isEligible = (age >= 18) ? true : false;
        System.out.println("isEligible : " + isEligible);

        double num = 10.0;
        double den = 3.0;
        System.out.println(num/ den);
    }
}