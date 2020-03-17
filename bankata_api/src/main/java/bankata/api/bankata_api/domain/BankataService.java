package bankata.api.bankata_api.domain;

import bankata.api.bankata_api.domain.account.Account;
import bankata.api.bankata_api.domain.transactions.Deposit;
import bankata.api.bankata_api.domain.transactions.Withdrawal;
import bankata.api.bankata_api.infrastructure.IAccountRepository;
import bankata.api.bankata_api.service.IFormatter;
import bankata.api.bankata_api.service.ITimeServer;

public class BankataService {
    private final IAccountRepository repository;
    private final ITimeServer timeServer;
    private final IFormatter formatter;

    public BankataService(IAccountRepository repository, ITimeServer timeServer, IFormatter formatter) {

        this.repository = repository;
        this.timeServer = timeServer;
        this.formatter = formatter;
    }

    public void deposit(int amount, int accountId) {
        Account account = repository.get(accountId);
        account.add(new Deposit(amount, timeServer.getDate()));
        repository.save(account, accountId);
    }

    public void withdraw(int amount, int accountId) {
        Account account = repository.get(accountId);
        account.add(new Withdrawal(amount, timeServer.getDate()));
        repository.save(account, accountId);
    }

    public String getStatement() {
        return formatter.create();
    }
}
