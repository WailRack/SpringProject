package ru.ivan.deposit.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivan.deposit.dto.DepositRequestDTO;
import ru.ivan.deposit.dto.DepositResponseDTO;
import ru.ivan.deposit.repositoryes.DepositRepository;
import ru.ivan.deposit.rest.AccountServiceClient;
import ru.ivan.deposit.rest.BillServiceClient;

@Service
public class DepositService {

    private final DepositRepository depositRepository;
    private final AccountServiceClient accountServiceClient;
    private final BillServiceClient billServiceClient;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public DepositService(DepositRepository depositRepository, AccountServiceClient accountServiceClient,
                          BillServiceClient billServiceClient, RabbitTemplate rabbitTemplate) {
        this.depositRepository = depositRepository;
        this.accountServiceClient = accountServiceClient;
        this.billServiceClient = billServiceClient;
        this.rabbitTemplate = rabbitTemplate;
    }

}
