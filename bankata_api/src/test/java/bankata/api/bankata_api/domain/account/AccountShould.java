package bankata.api.bankata_api.domain.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountShould {

    @Test
    public void throw_error_if_a_negative_amount_transaction(){
        Account account = new Account();

        Assertions.assertThrows(NegativeAmountException.class, () -> account.deposit(-1, "18/03/2020"));
        Assertions.assertThrows(NegativeAmountException.class, () -> account.withdraw(-1, "18/03/2020"));
    }

    @Test
    public void throw_error_if_withdrawal_amount_exceeds_current_balance(){
        Account account = new Account();

        Assertions.assertThrows(NotEnoughMoneyException.class, () -> account.withdraw(20, "18/03/2020"));
    }

    @Test
    public void update_balance_on_deposit(){
        Account account = new Account();

        account.deposit(100, "18/03/2020");

        Assertions.assertTrue(account.checkBalance(100));
    }

    @Test
    public void update_balance_on_withdraw(){
        Account account = new Account();
        account.deposit(100, "15/03/2020");

        account.withdraw(80, "18/03/2020");

        Assertions.assertTrue(account.checkBalance(20));
    }


}
