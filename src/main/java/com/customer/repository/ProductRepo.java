package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.entity.ProductEntity;
@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
