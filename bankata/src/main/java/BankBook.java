import java.util.ArrayList;
import java.util.List;

public class BankBook {
    private List<String> bankBook;

    public BankBook(){
        bankBook = new ArrayList<>();
        bankBook.add(" date || credit || debit || balance\n");
    }

    public void deposit(String date, int depositAmount, int balance) {
        bankBook.add(date + "||" + depositAmount + "||   ||" + balance + "\n");
    }

    public void withdraw(String date, int withdrawAmount, int balance) {
        bankBook.add(date + "||   ||" + withdrawAmount + "||" + balance + "\n");
    }

    public String print() {
        String printResponse = "";
        for(String entry: bankBook) {
            printResponse += entry;
        }
        return printResponse;
    }
}