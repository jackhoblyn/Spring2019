package com.eShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eShop.model.Stock;
import com.eShop.repository.StockRepository;

@Service
public class StockService {
	
	
	@Autowired
	private StockRepository stockRepository;
	
	
	public void createStock(Stock stock) {
		stockRepository.save(stock);
	}
	
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

	public List<Stock> findByTitle(String title) {
		return stockRepository.findByTitle(title);
	}
	

}
