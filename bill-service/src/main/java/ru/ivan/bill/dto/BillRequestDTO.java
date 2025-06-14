package ru.ivan.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class BillRequestDTO {

    private Long id;

    private Long accountId;

    private BigDecimal amount;

    private Boolean idDefault;

    private OffsetDateTime creationDate;

    private Boolean overdraftEnabled;
}
