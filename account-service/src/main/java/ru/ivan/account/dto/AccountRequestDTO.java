package ru.ivan.account.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
public class AccountRequestDTO {

    private long id;

    private String username;

    private String email;

    private String phone;

    private OffsetDateTime creationTime;

    private List<Long> bills;
}
