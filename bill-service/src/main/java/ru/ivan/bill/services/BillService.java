package ru.ivan.bill.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ivan.bill.exceptions.BillNotFoundException;
import ru.ivan.bill.models.Bill;
import ru.ivan.bill.repositoryes.BillRepository;

@Service
public class BillService {

    private BillRepository billRepository;

    @Autowired
    public void setBillRepository(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill findById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new BillNotFoundException("not found by id: " + id));
    }

    public Long createBill(Bill bill) {
        return billRepository.save(bill).getId();
    }
}
