import org.junit.Assert;
import org.junit.Test;

public class BankataShould {
    @Test
    public void add_1000_on_a_1000_desposit(){
        Account account = new Account();
        account.deposit("21/11/2010", 1000);
        Assert.assertEquals(" date || credit || debit || balance\n21/11/2010||1000||   ||1000\n", account.printStatement());
    }

    @Test
    public void sub_500_on_a_500_withdrawal(){
        Account account = new Account();
        account.withdraw("21/11/2010", 500);
        Assert.assertEquals(" date || credit || debit || balance\n21/11/2010||   ||500||-500\n", account.printStatement());
    }
}