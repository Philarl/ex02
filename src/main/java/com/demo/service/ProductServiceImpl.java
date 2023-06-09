package com.demo.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.demo.domain.ProductVO;
import com.demo.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Inject
	private ProductMapper productMapper;

	@Override
	public void pro_insert(ProductVO product) {
		
		productMapper.pro_insert(product);
		
	}

}
