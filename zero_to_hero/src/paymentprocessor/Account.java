package paymentprocessor;

import java.util.Arrays;

public class Account {
    private static final int DEFAULT_TRANSACTION_AMOUNT = 10;
    private int id;
    private Transaction[] transactions;
    private int lastTransactionIndex;

    {
        transactions = new Transaction[DEFAULT_TRANSACTION_AMOUNT];
    }

    public Account(int id) {
        this.id = id;
    }

    public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
        if (accountTo == null) return;
        if (moneyAmount <= 0) return;
        Transaction transaction = new Transaction(this, accountTo, moneyAmount, StandardAccountOperations.MONEY_TRANSFER_SEND);
        addTransaction(transaction);
        accountTo.receiveMoney(this, moneyAmount);
    }

    private void receiveMoney(Account accountFrom, double moneyAmount) {
        if (accountFrom == null) return;
        if (moneyAmount <= 0) return;
        Transaction transaction = new Transaction(accountFrom, this, moneyAmount, StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
        addTransaction(transaction);
    }

    private void addTransaction(Transaction transaction) {
        if (transaction == null) return;
        if (transactions.length <= lastTransactionIndex) {
            transactions = Arrays.copyOf(transactions, transactions.length << 1);
        }
        transactions[lastTransactionIndex++] = transaction;
    }

    public void withdrawMoney(double moneyAmount) {
        Transaction transaction = new Transaction(this, null, moneyAmount, StandardAccountOperations.WITHDRAW);
        addTransaction(transaction);
    }

    public Transaction[] getTransactions() {
        int nonNullTransactionsAmount = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                nonNullTransactionsAmount++;
            }
        }

        Transaction[] filteredTransactions = new Transaction[nonNullTransactionsAmount];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                filteredTransactions[index++] = transaction;
            }
        }
        return filteredTransactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }

    public static class Transaction {
        Account accountFrom;
        Account accountTo;
        double moneyAmount;
        StandardAccountOperations operation;

        public Transaction(Account accountFrom, Account accountTo, double moneyAmount, StandardAccountOperations operation) {
            this.accountFrom = accountFrom;
            this.accountTo = accountTo;
            this.moneyAmount = moneyAmount;
            this.operation = operation;
        }

        public Account getAccountFrom() {
            return accountFrom;
        }

        public void setAccountFrom(Account accountFrom) {
            this.accountFrom = accountFrom;
        }

        public Account getAccountTo() {
            return accountTo;
        }

        public void setAccountTo(Account accountTo) {
            this.accountTo = accountTo;
        }

        public double getMoneyAmount() {
            return moneyAmount;
        }

        public void setMoneyAmount(double moneyAmount) {
            this.moneyAmount = moneyAmount;
        }

        public StandardAccountOperations getOperation() {
            return operation;
        }

        public void setOperation(StandardAccountOperations operation) {
            this.operation = operation;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "accountFrom=" + accountFrom +
                    ", accountTo=" + accountTo +
                    ", moneyAmount=" + moneyAmount +
                    ", operation=" + operation +
                    '}';
        }
    }
}
