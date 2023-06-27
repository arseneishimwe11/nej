package com.nepractice.services;

import com.nepractice.model.Product;
import com.nepractice.model.Purchased;
import com.nepractice.model.Quantity;
import com.nepractice.repository.ProductRepository;
import com.nepractice.repository.PurchasedRepository;
import com.nepractice.repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductManagementService {
    private final ProductRepository productRepository;
    private final QuantityRepository quantityRepository;
    private final PurchasedRepository purchasedRepository;


    @Autowired
    public ProductManagementService(ProductRepository productRepository, QuantityRepository quantityRepository, PurchasedRepository purchasedRepository) {
        this.productRepository = productRepository;
        this.quantityRepository = quantityRepository;
        this.purchasedRepository = purchasedRepository;
    }

    public void registerProduct(Product product) {
        productRepository.save(product);
        System.out.println(product);
        System.out.println("Product registered successfully!");
    }
    public void registerQuantity(Product productCode, Integer quantity, String operation, LocalDate date) {
        Quantity quantityEntry = new Quantity();
        quantityEntry.setProductCode(productCode);
        quantityEntry.setQuantity(quantity);
        quantityEntry.setOperation(operation);
        quantityEntry.setDate(date);
        System.out.println(quantityEntry);
        quantityRepository.save(quantityEntry);
        System.out.println("Quantity registered successfully!");
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public void addPurchasedItem(Product productId, int quantity, double total, LocalDate date) {
        Product product = productRepository.findByCode(productId.getCode());
//                .orElseThrow(() -> new IllegalArgumentException("Invalid product id: " + productId));
        if(product == null){
            System.out.println("No product found!");
        }
        Purchased purchasedItem = new Purchased();
        purchasedItem.setProductCode(productId);
        purchasedItem.setQuantity(quantity);
        purchasedItem.setTotal(total);
        purchasedItem.setDate(date);

        purchasedRepository.save(purchasedItem);
        System.out.println("Purchased item added successfully!");
    }
}

