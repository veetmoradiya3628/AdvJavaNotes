package ooad;

interface PaymentProcessor {
    int RETRY_ATTEMPTS = 5;
    void processPayment();
    default void someDefault(){
        System.out.println("Default Payment Processor");
    }

    static void staticMethod(){
        System.out.println("Static payment method processor");
    }
}

class Processor1 implements PaymentProcessor{

    @Override
    public void processPayment() {
        System.out.println("Processor1 processing");
    }

}

class Processor2 implements PaymentProcessor {

    @Override
    public void processPayment() {
        System.out.println("Processor2 processing");
    }

    @Override
    public void someDefault() {
        PaymentProcessor.super.someDefault();
        System.out.println("Additional from Processor2");
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(PaymentProcessor.RETRY_ATTEMPTS);
        PaymentProcessor.staticMethod();

        PaymentProcessor p1 = new Processor1();
        p1.processPayment();
        p1.someDefault();


        PaymentProcessor p2 = new Processor2();
        p2.processPayment();
        p2.someDefault();
    }
}
