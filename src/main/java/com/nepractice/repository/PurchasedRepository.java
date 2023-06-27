package com.nepractice.repository;

import com.nepractice.model.Product;
import com.nepractice.model.Purchased;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchasedRepository extends JpaRepository<Purchased, Long> {
//    List<Purchased> findAll();
}
