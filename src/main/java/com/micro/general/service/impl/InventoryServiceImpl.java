package com.micro.general.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.micro.general.beans.InventoryResponse;
import com.micro.general.beans.InvetoryRequest;
import com.micro.general.entity.Product;
import com.micro.general.repository.InventoryRepository;
import com.micro.general.service.IInvetoryService;

@Service
public class InventoryServiceImpl implements IInvetoryService{

	@Autowired
	private InventoryRepository invenRepo;
	
	@Override
	public void saveInvetoryProduct(InvetoryRequest rqPayload) {
		Product product =  new Product();
		product.setName(rqPayload.getName());
		product.setPrice(rqPayload.getPrice());
		product.setQty(rqPayload.getQuantity());
		product.setDesciption(rqPayload.getDesc());
		product.setCreatedAt(new Date());
		invenRepo.save(product);
	}

	@Override
	public void updateInvetoryProduct(InvetoryRequest rqPayload) {
		invenRepo.updatePriceQtyProduct(rqPayload.getPrice(), rqPayload.getQuantity(), new Date());
	}

	@Override
	public List<InventoryResponse> getListProduct(InvetoryRequest rqPayload) {
		List<InventoryResponse> rs = null;
		Pageable pagination = PageRequest.of(rqPayload.getPage(), rqPayload.getSize());
		Page<Product>products = invenRepo.findAll(pagination);
		if (products.getSize() > 0) {
			rs = new ArrayList<InventoryResponse>();
			for (Product prd : products) {
				InventoryResponse product = new InventoryResponse();
				product.setIdInvent(prd.getIdProduct());
				product.setDesc(prd.getDesciption());
				product.setName(prd.getName());
				product.setQuantity(prd.getQty());
				product.setPrice(prd.getPrice());
				rs.add(product);
			}
		}
		return rs;	}

	@Override
	public InventoryResponse getProductDetail(String idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
