package ru.ivan.deposit.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivan.deposit.models.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
