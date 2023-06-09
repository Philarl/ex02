package com.demo.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.domain.ProductVO;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	@GetMapping("/pro_insert")
	public void pro_insert() {
		
	}
	
	@PostMapping("/pro_insert")
	public String pro_insert(ProductVO product) {
		
		productService.pro_insert(product);
		
		return "redirect:/list";
	}
	

}
