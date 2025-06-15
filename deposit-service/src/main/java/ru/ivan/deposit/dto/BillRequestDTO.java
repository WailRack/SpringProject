package ru.ivan.deposit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BillRequestDTO {

    private Long id;

    private Long accountId;

    private BigDecimal amount;

    private Boolean idDefault;

    private OffsetDateTime creationDate;

    private Boolean overdraftEnabled;
}
