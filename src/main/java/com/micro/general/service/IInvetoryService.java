package com.micro.general.service;

import java.util.List;

import com.micro.general.beans.InventoryResponse;
import com.micro.general.exception.ApiException;
import com.micro.general.beans.InventoryRequest;

public interface IInvetoryService {
	
	public void saveInvetoryProduct(InventoryRequest product) throws ApiException;
	
	public void updateInvetoryProduct(InventoryRequest product) throws ApiException;
	
	public List<InventoryResponse> getListProduct(InventoryRequest payload);
	
	public InventoryResponse getProductDetail(String idProduct);
	
	public InventoryResponse getQtyProductById(String idProduct);
}
