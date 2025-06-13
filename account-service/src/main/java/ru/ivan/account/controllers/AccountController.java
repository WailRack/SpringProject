package ru.ivan.account.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivan.account.dto.AccountRequestDTO;
import ru.ivan.account.dto.AccountResponseDTO;
import ru.ivan.account.model.Account;
import ru.ivan.account.services.AccountService;

import javax.security.auth.login.AccountNotFoundException;

@RestController
@RequestMapping("/")
public class AccountController {

    private final AccountService accountService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public AccountResponseDTO getAccount(@PathVariable("accountId") Long accountId) throws AccountNotFoundException {
        return convertToAccountResponseDTO(accountService.getAccountById(accountId));
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        accountService.createAccount(accountRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountResponseDTO> updateAccount(@PathVariable("accountId") Long accountId,
                                                            @RequestBody AccountRequestDTO accountRequestDTO) throws AccountNotFoundException {
        accountService.updateAccount(accountRequestDTO, accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<AccountResponseDTO> deleteAccount(@PathVariable("accountId") Long accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private AccountResponseDTO convertToAccountResponseDTO(Account account) {
        return modelMapper.map(account, AccountResponseDTO.class);
    }

    private Account convertToAccount(AccountResponseDTO accountResponseDTO) {
        return modelMapper.map(accountResponseDTO, Account.class);
    }
}
