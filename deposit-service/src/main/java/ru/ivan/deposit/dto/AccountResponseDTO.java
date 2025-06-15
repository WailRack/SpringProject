package ru.ivan.deposit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class AccountResponseDTO {

    private long id;

    private String username;

    private String email;

    private String phone;

    private OffsetDateTime creationTime;

    private List<Long> bills;
}
