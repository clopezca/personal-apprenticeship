package acceptance;

import bankata.api.bankata_api.domain.BankataService;
import bankata.api.bankata_api.infrastructure.IAccountRepository;
import bankata.api.bankata_api.infrastructure.inMemory.InMemoryAccountRepository;
import bankata.api.bankata_api.service.Formatter;
import bankata.api.bankata_api.service.IFormatter;
import bankata.api.bankata_api.service.TimeServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;


public class PrintStatementShould {

    private IAccountRepository inMemoryTransactionRepository = new InMemoryAccountRepository();
    private IFormatter formatter = new Formatter();

    @Mock
    private TimeServer timeServer;

    @Test
    public void print_the_bank_Statement_correctly() {
        MockitoAnnotations.initMocks(this);

        BankataService bankataService = new BankataService(inMemoryTransactionRepository, timeServer, formatter);
        when(timeServer.getDate()).thenReturn("10/01/2012","13/01/2012","14/01/2012");
        bankataService.deposit(1000, 199);
        bankataService.deposit(2000, 199);
        bankataService.withdraw(500,199);

        Assertions.assertEquals("date       || credit   || debit    || balance\n" +
                "14/01/2012 ||          || 500.00   || 2500.00\n" +
                "13/01/2012 || 2000.00  ||          || 3000.00\n" +
                "10/01/2012 || 1000.00  ||          || 1000.00\n", bankataService.getStatement());
    }
}
