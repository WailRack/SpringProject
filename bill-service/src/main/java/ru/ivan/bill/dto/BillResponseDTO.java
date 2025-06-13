package ru.ivan.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@AllArgsConstructor
@Getter
public class BillResponseDTO {
    private Long id;

    private Long accountId;

    private BigDecimal amount;

    private Boolean idDefault;

    private OffsetDateTime creationDate;

    private Boolean overdraftEnabled;
}
