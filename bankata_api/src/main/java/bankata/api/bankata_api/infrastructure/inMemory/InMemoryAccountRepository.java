package bankata.api.bankata_api.infrastructure.inMemory;

import bankata.api.bankata_api.domain.account.Account;
import bankata.api.bankata_api.infrastructure.IAccountRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class InMemoryAccountRepository implements IAccountRepository {

    HashMap<Integer,Account> accounts = new HashMap<>();

    @Override
    public Account get(int accountId) {
        accounts.put(199,new Account());
        return accounts.get(accountId);
    }

    @Override
    public void save(Account account, int accountId) {
        accounts.remove(accountId);
        accounts.put(accountId,account);
    }
}
