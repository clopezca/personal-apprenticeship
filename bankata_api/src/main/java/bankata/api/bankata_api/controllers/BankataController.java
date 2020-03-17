package bankata.api.bankata_api.controllers;

import bankata.api.bankata_api.domain.BankataService;
import bankata.api.bankata_api.infrastructure.IAccountRepository;
import bankata.api.bankata_api.service.IFormatter;
import bankata.api.bankata_api.service.ITimeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankataController {

    @Autowired
    IAccountRepository inMemoryAccountRepository;
    @Autowired
    ITimeServer timeServer;
    @Autowired
    IFormatter formatter;

    @PostMapping(value = "/deposit", consumes = "application/json")
    public ResponseEntity<Object> deposit(@RequestBody TransactionUseCase transactionUseCase) {
        BankataService bankataService = new BankataService(inMemoryAccountRepository, timeServer, formatter);
        try {
        bankataService.deposit(transactionUseCase.amount, transactionUseCase.accountId);
        return new ResponseEntity<>("Deposit Transaction 👍🏻", HttpStatus.CREATED);
        }catch (Exception error) {
            return new ResponseEntity<>("algo has hecho mal", HttpStatus.BAD_REQUEST);
        }
    }
}
