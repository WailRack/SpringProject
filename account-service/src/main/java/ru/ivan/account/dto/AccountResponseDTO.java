package ru.ivan.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class AccountResponseDTO {

    private long id;

    private String username;

    private String email;

    private String phone;

    private OffsetDateTime creationTime;

    private List<Long> bills;
}
