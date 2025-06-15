package ru.ivan.deposit.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.ivan.deposit.dto.BillRequestDTO;
import ru.ivan.deposit.dto.BillResponseDTO;

@FeignClient(name = "bill-service")
public interface BillServiceClient {

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    BillResponseDTO getBill(@PathVariable("billId") Long accountId);

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    void updateBill(@PathVariable("billId") Long accountId,
                    @RequestBody BillRequestDTO billRequestDTO);
}