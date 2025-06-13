package ru.ivan.bill.repositoryes;

import org.springframework.data.repository.CrudRepository;
import ru.ivan.bill.models.Bill;

public interface BillRepository extends CrudRepository<Bill, Long> {
}
