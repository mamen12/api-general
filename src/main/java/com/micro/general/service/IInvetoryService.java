package com.micro.general.service;

import java.util.List;

import com.micro.general.beans.InventoryResponse;
import com.micro.general.beans.InvetoryRequest;

public interface IInvetoryService {
	
	public void saveInvetoryProduct(InvetoryRequest product);
	
	public void updateInvetoryProduct(InvetoryRequest product);
	
	public List<InventoryResponse> getListProduct(InvetoryRequest payload);
	
	public InventoryResponse getProductDetail(String idProduct);
}
