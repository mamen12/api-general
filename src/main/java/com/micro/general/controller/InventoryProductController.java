package com.micro.general.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.micro.general.beans.Response;
import com.micro.general.constant.ApiResponse;
import com.micro.general.service.IInvetoryService;
import com.micro.general.beans.InventoryRequest;
import com.micro.general.beans.InventoryResponse;
import com.micro.general.beans.Request;

@RestController
@RequestMapping("/inventory")
public class InventoryProductController {
	
	@Autowired
	private IInvetoryService invetoryService;

	
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<InventoryResponse>> getListInventoryProduct(@RequestBody Request<InventoryRequest> rq){
    	Response<List<InventoryResponse>> rs = new Response<List<InventoryResponse>>();
		List<InventoryResponse> listInvenProduct = invetoryService.getListProduct(rq.getRequestPayload());
		if (listInvenProduct != null) {
			rs.setData(listInvenProduct);
			rs.setStatusResponse(ApiResponse.SUCCESS);
		}else {
			rs.setStatusResponse(ApiResponse.DATA_NOT_FOUND);
		}
    	return rs;
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> addProductInvetory(@RequestBody Request<InventoryRequest> rq){
    	Response<String> rs = new Response<String>();
    	try {
    		invetoryService.saveInvetoryProduct(rq.getRequestPayload());
    		rs.setStatusResponse(ApiResponse.SUCCESS);
		} catch (Exception e) {
			rs.setStatusResponse(ApiResponse.FAILED);
		}
    	return rs;
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> updateProductInventory(@RequestBody Request<InventoryRequest> rq){
    	Response<String> rs = new Response<String>();
    	try {
    		invetoryService.updateInvetoryProduct(rq.getRequestPayload());
    		rs.setStatusResponse(ApiResponse.SUCCESS);
		} catch (Exception e) {
			rs.setStatusResponse(ApiResponse.FAILED);
		}
    	return rs;
    }
    
    
    @RequestMapping(value = "/detail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<InventoryResponse> getDetailProduct(@RequestBody Request<InventoryRequest> rq){
    	Response<InventoryResponse> rs = new Response<InventoryResponse>();
			InventoryResponse inven = invetoryService.getProductDetail(rq.getRequestPayload().getIdProduct());
			if (inven != null) {
				rs.setData(inven);
				rs.setStatusResponse(ApiResponse.SUCCESS);
			}else {
				rs.setStatusResponse(ApiResponse.DATA_NOT_FOUND);
			}
		return rs;
    }
    
    @RequestMapping(value = "/check-qty", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<InventoryResponse> getDetailQuantity(@RequestBody Request<InventoryRequest> rq){
    	Response<InventoryResponse> rs = new Response<InventoryResponse>();
		InventoryResponse inven = invetoryService.getQtyProductById(rq.getRequestPayload().getIdProduct());
		if (inven != null) {
			rs.setData(inven);
			rs.setStatusResponse(ApiResponse.SUCCESS);
		}else {
			rs.setStatusResponse(ApiResponse.DATA_NOT_FOUND);
		}
		return rs;
    }
    
    
    
    
}
