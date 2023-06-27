package com.nepractice.controller;
import com.nepractice.model.Product;
import com.nepractice.model.Quantity;
import com.nepractice.services.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products/")
public class ProductController {
    private final ProductManagementService productManagementService;

    @Autowired
    public ProductController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @PostMapping
    public void registerProduct(@RequestBody Product product) {
//        System.out.println(product);
        productManagementService.registerProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productManagementService.getAllProducts();
    }

    @PostMapping("/{productCode}/quantities")
    public void registerQuantity(
            @PathVariable Product productCode,
            @RequestBody Quantity quantity
    ) {
//        LocalDate parsedDate = LocalDate.parse(quantity.getDate()); // Parse the date string to LocalDate

        productManagementService.registerQuantity(productCode, quantity.getQuantity(), quantity.getOperation(), quantity.getDate());
    }
    record PurchasedDao(int quantity,double total,String date){
    };
    @PostMapping("/{productId}/quantities/purchased")
    public void addPurchasedItem(
            @PathVariable Product productId,
            @RequestBody PurchasedDao purchasedDao
           ) {
//        LocalDate parsedDate = LocalDate.parse(date);
        productManagementService.addPurchasedItem(productId, purchasedDao.quantity, purchasedDao.total, LocalDate.parse(purchasedDao.date));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
    public String sayHello() {
        return "Swagger Hello World";
    }
}