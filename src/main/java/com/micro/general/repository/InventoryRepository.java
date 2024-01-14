package com.micro.general.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.micro.general.entity.Product;

@Repository
public interface InventoryRepository extends JpaRepository<Product, String>{

	@Modifying
	@Query("UPDATE Product p SET p.price=:price, p.qty=:qty, p.updateAt=:update_at WHERE p.idProduct=:id_product")
	public void updatePriceQtyProduct(
			@Param("price") BigDecimal price,
			@Param("qty") Integer quantity,
			@Param("update_at") Date updateAt,
			@Param("id_product") String idProduct);
	
	@Query("SELECT p.qty FROM Product p WHERE p.idProduct=?1")
	public Integer getQtyProductById(String idProduct);
	
}
