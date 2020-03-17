package bankata.api.bankata_api.domain.transactions;

public class Withdrawal extends Transaction {
    private final int amount;
    private final String date;

    public Withdrawal(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }
}
