package com.demo.SpringSecurityTest.billManagement.services;

import com.demo.SpringSecurityTest.billManagement.entities.Bill;
import com.demo.SpringSecurityTest.billManagement.reposirories.BillRepositories;
import com.demo.SpringSecurityTest.customerManagement.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepositories billRepository;

    public List<Bill>getAllBills()
    {
        return billRepository.findAll();
    }

    public Bill saveBill(Bill Bill)
    {
        return billRepository.save(Bill);
    }

    public Bill deleteBill(Long id)
    {
        Optional<Bill> bill = this.billRepository.findById(id);
        billRepository.delete(bill.get());
        return bill.get();
    }

    public Bill updateBill(Bill bill)
    {
        Optional<Bill> currentBill = billRepository.findById(bill.getId_bill());
        if(currentBill.isPresent())
        {
            billRepository.saveAndFlush(bill);
            return currentBill.get();
        }
        else return null;
    }
}
