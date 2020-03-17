package bankata.api.bankata_api.infrastructure;

import bankata.api.bankata_api.domain.account.Account;

public interface IAccountRepository {
    Account get(int accountId);
    void save(Account account, int accountId);
}
