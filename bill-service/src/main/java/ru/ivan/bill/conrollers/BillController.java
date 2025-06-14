package ru.ivan.bill.conrollers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ivan.bill.dto.BillRequestDTO;
import ru.ivan.bill.dto.BillResponseDTO;
import ru.ivan.bill.models.Bill;
import ru.ivan.bill.services.BillService;

@RestController
public class BillController {

    private final BillService billService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/{id}")
    public Bill getBill(@PathVariable("id") Long id) {
        return billService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> createBill (@RequestBody Bill bill) {
        billService.createBill(bill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillResponseDTO> updateBill(@RequestBody Bill bill,
                                                      @PathVariable("id") Long id) {
        billService.updateBill(bill, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BillResponseDTO> deleteBill(@PathVariable("id") Long id) {
        billService.deleteBill(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private BillResponseDTO convertToBillResponseDTO(Bill bill) {
        return modelMapper.map(bill, BillResponseDTO.class);
    }

    private Bill convertToBill(BillRequestDTO bill) {
        return modelMapper.map(bill, Bill.class);
    }
}
