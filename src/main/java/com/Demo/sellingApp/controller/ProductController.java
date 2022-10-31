package com.Demo.sellingApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.sellingApp.config.Response;
import com.Demo.sellingApp.dto.ProductMasterDto;
import com.Demo.sellingApp.entity.ProductMaster;
import com.Demo.sellingApp.service.ClientMasterService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ClientMasterService clientMasterService;
	
	@PostMapping("/product_save")
	public Response saveProductMaster(@Valid @RequestBody ProductMasterDto productMasterDto) {
		return clientMasterService.saveProductMaster(productMasterDto);
	}
	
	@GetMapping("/product")
	public List<ProductMasterDto> fetchProductMasterList(){
		return clientMasterService.fetchProductMasterList();
	}
	
	@PutMapping("/product")
	ResponseEntity<String> updateProductMaster(@Valid @RequestBody ProductMasterDto productMasterDto){
		return clientMasterService.updateProductMaster(productMasterDto);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	 public String remove(@PathVariable Integer id) {
		clientMasterService.remove(id);
		return "Producted inactive successfully";
	}
	
//	@GetMapping("/pro/{id}")
//	public ProductMasterDto getProductMaster(@PathVariable Integer pId) {
//		return clientMasterService.getProductMaster(pId);
//	} 

	
}
