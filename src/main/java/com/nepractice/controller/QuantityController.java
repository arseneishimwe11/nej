package com.nepractice.controller;

import com.mbyj.model.Product;
import com.nepractice.model.Quantity;
//import com.nepractice.services.ProductService;
import com.nepractice.services.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/quantities")
public class QuantityController {
    private final QuantityService quantityService;
//    private final ProductService productService;

    @Autowired
    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
//        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<?> getAllQuantities() {
        return ResponseEntity.ok(quantityService.getAllQuantities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuantityById(@PathVariable Long id) {
        Quantity quantity = quantityService.getQuantityById(id);
        if (quantity != null) {
            return ResponseEntity.ok(quantity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quantity not found");
        }
    }

//    @PostMapping
//    public ResponseEntity<?> createQuantity(@RequestBody QuantityRequest quantityRequest) {
//        Optional<Product> product = productService.getProductById(quantityRequest.getProductId());
//        Quantity newQuantity = new Quantity(product.get(), quantityRequest.getQuantity(), quantityRequest.getOperation(), quantityRequest.getDate());
//
//        Quantity createdQuantity = quantityService.saveQuantity(newQuantity);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuantity);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuantity(@PathVariable Long id) {
        quantityService.deleteQuantity(id);
        return ResponseEntity.noContent().build();
    }
}