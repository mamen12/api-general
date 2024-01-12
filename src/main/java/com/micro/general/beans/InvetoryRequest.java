package com.micro.general.beans;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class InvetoryRequest extends BaseRequest{
	
	@JsonProperty(value = "id_product")
	private String id_product;
	
	@JsonProperty(value = "name_product")
	private String name;

	@JsonProperty(value = "price_product")
	private BigDecimal price;
	
	@JsonProperty(value = "qty_product")
	private Integer quantity;
	
	@JsonProperty(value = "desc_product")
	private String desc;
	
	@JsonProperty(value = "page")
	private String page;
	
	

	public String getId_product() {
		return id_product;
	}

	public void setId_product(String id_product) {
		this.id_product = id_product;
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
