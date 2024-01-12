package com.micro.general.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mt_product", schema ="general")
public class Product implements Serializable{
	  
	/**
	 * syahrul added 12-01-2024
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	@Column(name = "id_product", length = 36)
	private String idProduct;
	
	private String name;
	
	private BigDecimal price;
	
	private Integer qty;
	
	private String desciption;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updateAt;

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

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
}
