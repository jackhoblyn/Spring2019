package com.eShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eShop.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

}
