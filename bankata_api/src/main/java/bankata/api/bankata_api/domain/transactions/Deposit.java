package bankata.api.bankata_api.domain.transactions;

public class Deposit extends Transaction {
    private final int amount;
    private final String date;

    public Deposit(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }
}
