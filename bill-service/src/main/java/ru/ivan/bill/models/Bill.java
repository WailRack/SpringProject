package ru.ivan.bill.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "bill")

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountId;

    private BigDecimal amount;

    private Boolean idDefault;

    private OffsetDateTime creationDate;

    private Boolean overdraftEnabled;

    public Bill(Long accountId, BigDecimal amount, Boolean idDefault,
                OffsetDateTime creationDate, Boolean overdraftEnabled) {
        this.accountId = accountId;
        this.amount = amount;
        this.idDefault = idDefault;
        this.creationDate = creationDate;
        this.overdraftEnabled = overdraftEnabled;
    }
}
