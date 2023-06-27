package com.nepractice.services;

import com.nepractice.model.Purchased;
import com.nepractice.repository.PurchasedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasedService {
    private final PurchasedRepository purchasedRepository;

    @Autowired
    public PurchasedService(PurchasedRepository purchasedRepository) {
        this.purchasedRepository = purchasedRepository;
    }

    public List<Purchased> getAllPurchasedItems() {
        return purchasedRepository.findAll();
    }

    public Purchased getPurchasedItemById(Long id) {
        return purchasedRepository.findById(id).orElse(null);
    }

    public Purchased savePurchasedItem(Purchased purchased) {
        return purchasedRepository.save(purchased);
    }

    public void deletePurchasedItem(Long id) {
        purchasedRepository.deleteById(id);
    }
}