package paymentprocessor;

import java.util.Arrays;

public class TransactionDriver {
    public static void main(String[] args) {
        Account a1 = new Account(1);
        Account a2 = new Account(2);

        a1.sendMoneyToAccount(a2, 100);
        a2.sendMoneyToAccount(a1, 50);

        a1.withdrawMoney(10);
        a2.withdrawMoney(10);

        System.out.println(Arrays.toString(a1.getTransactions()));
        System.out.println(Arrays.toString(a2.getTransactions()));
    }
}
