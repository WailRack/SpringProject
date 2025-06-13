package ru.ivan.account.repositoryes;

import org.springframework.data.repository.CrudRepository;
import ru.ivan.account.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
