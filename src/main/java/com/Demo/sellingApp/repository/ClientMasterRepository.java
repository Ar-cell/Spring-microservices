package com.Demo.sellingApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Demo.sellingApp.entity.ClientMaster;
import com.Demo.sellingApp.entity.ProductMaster;

@Repository
public interface ClientMasterRepository extends JpaRepository<ClientMaster, Integer> {

	Optional<ClientMaster> findByPid(Integer productId);
	
	
	
}
