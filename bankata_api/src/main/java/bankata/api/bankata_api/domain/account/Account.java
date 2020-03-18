package bankata.api.bankata_api.domain.account;

import bankata.api.bankata_api.domain.transactions.Deposit;
import bankata.api.bankata_api.domain.transactions.Transaction;
import bankata.api.bankata_api.domain.transactions.Withdrawal;

import java.util.ArrayList;

public class Account {
    private final ArrayList<Transaction> transactions;
    private int balance;

    public Account() {
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public void deposit(int amount, String date) {
        if(amount < 0) throw new NegativeAmountException();
        this.balance += amount;
        transactions.add(new Deposit(amount, date));
    }

    public void withdraw(int amount, String date) {
        if(amount < 0) throw new NegativeAmountException();
        if(amount > balance) throw new NotEnoughMoneyException();
        this.balance -= amount;
        transactions.add(new Withdrawal(amount, date));
    }

    public boolean checkBalance(int amount) {
        return amount == this.balance;
    }
}


