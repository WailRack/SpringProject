package ru.ivan.deposit.rest;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "bill-service")
public interface BillServiceClient {
}
