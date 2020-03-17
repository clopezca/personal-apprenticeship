package bankata.api.bankata_api.domain.account;

import bankata.api.bankata_api.domain.transactions.Transaction;

import java.util.ArrayList;

public class Account {
    private final ArrayList<Transaction> transactions;

    public Account() {
        this.transactions = new ArrayList<>();
    }

    public void add(Transaction transaction) {
        transactions.add(transaction);
    }
}
