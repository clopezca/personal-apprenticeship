public class Account {
    private int balance = 0;
    private BankBook bankBook;

    public Account() {
        bankBook = new BankBook();
    }

    public void deposit(String date, int depositAmount) {
        balance += depositAmount;
        bankBook.deposit(date, depositAmount, balance);
    }

    public void withdraw(String date, int withdrawAmount) {
        balance -= withdrawAmount;
        bankBook.withdraw(date, withdrawAmount, balance);
    }

    public String printStatement() {
        return bankBook.print();
    }
}