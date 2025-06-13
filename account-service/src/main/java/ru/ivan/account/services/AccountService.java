package ru.ivan.account.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivan.account.dto.AccountRequestDTO;
import ru.ivan.account.model.Account;
import ru.ivan.account.repositoryes.AccountRepository;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // исправить эту залупу
    public Account getAccountById(Long id) throws AccountNotFoundException {
        return accountRepository.findById(id).orElseThrow(
                () -> new AccountNotFoundException("Unable to find account with id: " + id));
    }

    public void createAccount(AccountRequestDTO account) {
        Account accountForCreate = Account.builder()
                .username(account.getUsername())
                .email(account.getEmail())
                .phone(account.getPhone())
                .bills(account.getBills())
                .creationTime(account.getCreationTime())
                .build();

        accountRepository.save(accountForCreate);
    }

    public void updateAccount(AccountRequestDTO account, Long id) throws AccountNotFoundException {
        Account accountForUpdate = getAccountById(id);
        accountForUpdate.setUsername(account.getUsername());
        accountForUpdate.setEmail(account.getEmail());
        accountForUpdate.setPhone(account.getPhone());
        accountForUpdate.setBills(account.getBills());

        accountRepository.save(accountForUpdate);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
