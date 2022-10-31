package com.Demo.sellingApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Demo.sellingApp.entity.ProductMaster;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
	
	Optional<ProductMaster> findByPid(Integer productId);
	
	void findBypId(Integer pId);
	
//	 public void remove(Integer id);

}
