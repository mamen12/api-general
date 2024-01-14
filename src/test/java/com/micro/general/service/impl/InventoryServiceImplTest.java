package com.micro.general.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.commons.beans.beans.InventoryRequest;
import com.commons.beans.beans.InventoryResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.general.entity.Product;
import com.micro.general.repository.InventoryRepository;
import com.micro.general.service.IInvetoryService;


@SpringBootTest
public class InventoryServiceImplTest {
	
	Logger logger = LoggerFactory.getLogger(InventoryServiceImplTest.class);
	
	@Autowired
	private IInvetoryService invenService;
	
	@Autowired
	private InventoryRepository invenRepo;
	
	@Test
	public void insertProductInvetory() {
		Integer isSuccess = 1;
		invenRepo.deleteAll();
		InventoryRequest rq = new InventoryRequest();
		rq.setName("Kopi");
		rq.setPrice(new BigDecimal(10000));
		rq.setQuantity(900);
		rq.setDesc("Ini kopi nescafe");
		
		try {
			invenService.saveInvetoryProduct(rq);
			isSuccess = 0;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		assertEquals(isSuccess, 0);
	}
	
	
	@Test
	public void errorInsertProductInvetory() {
		Integer isSuccess = 1;
		InventoryRequest rq = new InventoryRequest();
		rq.setName("Kopi");
		rq.setPrice(new BigDecimal(10000));
		rq.setQuantity(900);
		rq.setDesc("Ini kopi nescafe");
		
		try {
			invenService.saveInvetoryProduct(rq);
			isSuccess= 0;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		assertNotEquals(isSuccess, 0);

	}
	
	@Test
	public void getListInventoryProduct() {
		saveAllProduct();
		InventoryRequest rq = new InventoryRequest();
		rq.setPage(1);
		rq.setSize(10);
		List<InventoryResponse> rs = invenService.getListProduct(rq);
		assertEquals(rq.getSize(), rs.size());
		logger.info("Banyak Product yang ditampilkan sebanyak : " + rs.size());
	}
	
	@Test
	public void updateProductInvetory() {
		InventoryRequest rq = new InventoryRequest();
		rq.setIdProduct("bbf3241c-ee9c-43e1-9852-4db451151876");
		rq.setPrice(new BigDecimal(90000));
		rq.setQuantity(10000);
		try {
			invenService.updateInvetoryProduct(rq);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		Product product = invenRepo.findById("bbf3241c-ee9c-43e1-9852-4db451151876").orElseThrow();
		assertEquals(product.getQty(), rq.getQuantity());
	}
	
	@Test
	public void getProductDetailByIdProduct() {
		ObjectMapper mapper = new ObjectMapper();
		InventoryRequest rq = new InventoryRequest();
		rq.setIdProduct("bbf3241c-ee9c-43e1-9852-4db451151876");
		try {
			InventoryResponse rs = invenService.getProductDetail(rq.getIdProduct());
			assertEquals(10000, rs.getQuantity());
			logger.info(mapper.writeValueAsString(rs));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
	
	@Test
	public void getQuantityProductByIdProduct() {
		InventoryRequest rq = new InventoryRequest();
		rq.setIdProduct("bbf3241c-ee9c-43e1-9852-4db451151876");
		InventoryResponse i = invenService.getQtyProductById(rq.getIdProduct());
		logger.info(i.getQuantity().toString());
	}
	
	public void saveAllProduct() {
		List<Product> products = new ArrayList<Product>(); 
		for (int i = 1; i < 15; i++) {
			Product product =  new Product();
			product.setName("kopi" + i);
			product.setPrice(new BigDecimal(1000 + i));
			product.setQty(100 + i);
			product.setDesciption("ini kopi mantap urutan" + i);
			product.setCreatedAt(new Date());
			products.add(product);
		}
		invenRepo.saveAll(products);
	}
	
	
}
