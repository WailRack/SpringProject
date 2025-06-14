package ru.ivan.bill.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivan.bill.models.Bill;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Optional<Bill> findById(Long id);
}
