package ru.ivan.deposit.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.ivan.deposit.dto.AccountResponseDTO;

@FeignClient(name = "account-service")
public interface AccountServiceClient {

    @RequestMapping(value = "/account/{accountId}", method = RequestMethod.GET)
    AccountResponseDTO getAccountById(@PathVariable("accountId") long id);
}
