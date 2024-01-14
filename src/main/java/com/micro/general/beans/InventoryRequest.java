package com.micro.general.beans;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class InventoryRequest extends BaseRequest{
	
	@JsonProperty(value = "id_product")
	private String idProduct;
	
	@JsonProperty(value = "name_product")
	private String name;

	@JsonProperty(value = "price_product")
	private BigDecimal price;
	
	@JsonProperty(value = "qty_product")
	private Integer quantity;
	
	@JsonProperty(value = "desc_product")
	private String desc;
	
	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
