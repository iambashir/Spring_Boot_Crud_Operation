package com.mtr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtr.model.Product;
import com.mtr.repository.ProductRepositry;

@Service
public class ProductService {

	@Autowired
	private ProductRepositry pr;
	
	public List<Product> getAllProducts(){
		return pr.findAll();
	}
	
	public void saveProduct(Product product) {
		pr.save(product);
	}
	
	public Product getProduct(int id) {
		return pr.findById(id).get();
	}
	
	public void deleteProduct(int id) {
		pr.deleteById(id);
	}
}
