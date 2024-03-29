package com.micro.general.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.commons.beans.beans.InventoryRequest;
import com.commons.beans.beans.InventoryResponse;
import com.commons.beans.constant.AppConstants;
import com.micro.general.entity.Product;
import com.micro.general.exception.ApiException;
import com.micro.general.repository.InventoryRepository;
import com.micro.general.service.IInvetoryService;

import jakarta.transaction.Transactional;

@Service
public class InventoryServiceImpl implements IInvetoryService{
	
	Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);

	@Autowired
	private InventoryRepository invenRepo;
	
	@Override
	public void saveInvetoryProduct(InventoryRequest rqPayload) throws ApiException {
		Product product =  new Product();
		product.setName(rqPayload.getName());
		product.setPrice(rqPayload.getPrice());
		product.setQty(rqPayload.getQuantity());
		product.setDesciption(rqPayload.getDesc());
		product.setCreatedAt(new Date());
		try {
			invenRepo.save(product);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ApiException(AppConstants.SAVED_FAILED);
		}
	}

	@Transactional
	@Override
	public void updateInvetoryProduct(InventoryRequest rqPayload) throws ApiException {
		try {
			Product product = invenRepo.findById(rqPayload.getIdProduct()).orElseThrow();
			invenRepo.updatePriceQtyProduct(
					rqPayload.getPrice() != null ? rqPayload.getPrice() :product.getPrice() ,
					rqPayload.getQuantity() != null ? rqPayload.getQuantity(): product.getQty(),
				new Date(), rqPayload.getIdProduct());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ApiException(AppConstants.UPDATE_FAILED);
		}
	}

	@Override
	public List<InventoryResponse> getListProduct(InventoryRequest rqPayload) {
		List<InventoryResponse> rs = null;
		try {
			Pageable pagination = PageRequest.of(rqPayload.getPage() - 1, rqPayload.getSize());
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
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return rs;	
	}

	@Transactional
	@Override
	public InventoryResponse getProductDetail(String idProduct) {
		InventoryResponse rs = null;
		try {
			if(invenRepo.existsById(idProduct)) {
				Product product = invenRepo.findById(idProduct).orElseThrow();
				rs = new InventoryResponse();
				rs.setIdInvent(product.getIdProduct());
				rs.setName(product.getName());
				rs.setPrice(product.getPrice());
				rs.setDesc(product.getDesciption());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rs; 
	}

	@Transactional
	@Override
	public InventoryResponse getQtyProductById(String idProduct) {
		InventoryResponse rs = null;
		try {
			if(invenRepo.existsById(idProduct)) {
				Integer qtyProductInven =  invenRepo.getQtyProductById(idProduct);
				rs = new InventoryResponse();
				rs.setQuantity(qtyProductInven);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return rs;
	}
	
}
