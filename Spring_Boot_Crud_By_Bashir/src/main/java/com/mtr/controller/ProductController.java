package com.mtr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mtr.model.Product;
import com.mtr.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@GetMapping("/product")
	public String product(Model model) {
		List<Product> p = ps.getAllProducts();
		
		model.addAttribute("product", p);
		
		return "product";
	}
	
	@GetMapping("/addProductForm")
	public String showProductForm(Model model) {
		Product product = new Product();
		
		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		ps.saveProduct(product);
		
		return "redirect:/product";
	}
	
	@GetMapping("/editProduct")
	public String editProduct(Model model, @RequestParam("id") int id) {
		
		Product p = ps.getProduct(id);
		model.addAttribute("product", p);
		
		return "updateProduct";
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product product) {
		ps.saveProduct(product);
		
		return "redirect:/product";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") int id) {
		ps.deleteProduct(id);
		return "redirect:/product";
	}
	
}
