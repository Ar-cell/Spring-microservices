package com.Demo.sellingApp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Demo.sellingApp.config.Response;
import com.Demo.sellingApp.dto.ClientMasterDto;
import com.Demo.sellingApp.dto.ProductMasterDto;
import com.Demo.sellingApp.entity.ClientMaster;
import com.Demo.sellingApp.entity.ProductMaster;

@Service
public interface ClientMasterService {


	//save Client
	Response saveClients(ClientMasterDto clientmasterDto);
	
	//save product
	Response saveProductMaster(ProductMasterDto productMasterDto);
	
	//fetch client
	List<ClientMasterDto> fetchClientMasterList();
	
	//fetch product
	List<ProductMasterDto> fetchProductMasterList();
	
	//soft delete product
	void remove(Integer id);
	
	
	//update Client
	ResponseEntity<String> updateClientMaster(ClientMasterDto clientmasterDto );
	
	
	//update product
	ResponseEntity<String> updateProductMaster(ProductMasterDto productMasterDto);

//	ProductMasterDto getProductMaster(Integer pId);

	

}
