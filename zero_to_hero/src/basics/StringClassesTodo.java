package basics;

public class StringClassesTodo {
    public static void main(String[] args) {
        StringBuffer strBuffer = new StringBuffer("Hello");
        strBuffer.append(" World!");
        System.out.println(strBuffer);

        String sb = strBuffer.toString();
        System.out.println(sb);

        StringBuilder sbuilder = new StringBuilder(sb);
        sbuilder.setCharAt(0, 'A');
        System.out.println(sbuilder.toString());
    }
}
