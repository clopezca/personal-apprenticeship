package bankata.api.bankata_api.controllers;

import bankata.api.bankata_api.domain.account.Account;
import bankata.api.bankata_api.infrastructure.IAccountRepository;
import bankata.api.bankata_api.service.IFormatter;
import bankata.api.bankata_api.service.TimeServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankataControllerShould {
    @Mock
    private IAccountRepository inMemoryAccountRepository;
    @Mock
    private IFormatter formatter;
    @Mock
    private TimeServer timeServer;
    @InjectMocks
    private BankataController bankataController;

    @Test
    public void create_deposit() {
        MockitoAnnotations.initMocks(this);
        when(inMemoryAccountRepository.get(199)).thenReturn(new Account());

        TransactionUseCase transactionUseCase = new TransactionUseCase();
        transactionUseCase.amount = 1000;
        transactionUseCase.accountId = 199;
        transactionUseCase.date = "17/03/2020";
        ResponseEntity<Object> response = bankataController.deposit(transactionUseCase);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals("Deposit Transaction 👍🏻", response.getBody());
    }

}
