package com.Demo.sellingApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Demo.sellingApp.config.Response;
import com.Demo.sellingApp.dto.ClientMasterDto;
import com.Demo.sellingApp.dto.ProductMasterDto;
import com.Demo.sellingApp.entity.ClientMaster;
import com.Demo.sellingApp.entity.ProductMaster;
import com.Demo.sellingApp.repository.ClientMasterRepository;
import com.Demo.sellingApp.repository.ProductMasterRepository;
import com.google.gson.Gson;


@Service
public class ServiceImpl implements ClientMasterService {
	
	@Autowired
	ClientMasterRepository clientMasterRepository;
	
	@Autowired
	ProductMasterRepository productMasterRepository;
	
	@Autowired
	Gson gson;
	
	
	//save client 
	@Override
	public Response saveClients(ClientMasterDto clientMasterDto) {
		
		ClientMaster client =new ClientMaster();
		client.setName(clientMasterDto.getName());
		client.setEmail(clientMasterDto.getEmail());
		client.setPhoneno(clientMasterDto.getPhoneno());
		client.setAddress(clientMasterDto.getAddress());
		client.setUserid(clientMasterDto.getUserid());
		Optional<ProductMaster> productOptional = productMasterRepository.findByPid(clientMasterDto.getPid());
		if(productOptional.isPresent()) {
			ProductMaster productMaster=productOptional.get();
			client.setPid(productMaster.getPid());
			client.setProductMaster(productMaster);
		}		
		clientMasterRepository.save(client);
		
		return new Response("saved successfully",HttpStatus.OK);
	}
	
	
	//save product
	@Override
	public Response saveProductMaster(ProductMasterDto productMasterDto) {
		
		ProductMaster productMaster =new ProductMaster();
		productMaster.setProductname(productMasterDto.getProductname());
		productMaster.setProductprice(productMasterDto.getProductprice());
		productMaster.setQuantiy(productMasterDto.getQuantiy());
		productMaster.setType(productMasterDto.getType());
		productMaster.setStatus(1);
		productMasterRepository.save(productMaster);
		
		return new Response("Product Data saved Success fully", HttpStatus.OK);
	}
	
	
	
//	public ResponseEntity<Integer> setQuantity(ProductMasterDto productDto, ClientMaster client) {
//		Optional<ClientMaster> master = clientMasterRepository.
//	}
	
	
	// fetch Product
	@Override
	public List<ProductMasterDto> fetchProductMasterList() {
		List<ProductMasterDto> dtoProduct = new ArrayList<>();
		List<ProductMaster> productList = productMasterRepository.findAll();
		for(ProductMaster product: productList) {
			ProductMasterDto dto = new ProductMasterDto();
			dto.setProductname(product.getProductname());
			dto.setProductprice(product.getProductprice());
			dto.setQuantiy(product.getQuantiy());
			dto.setPid(product.getPid());
			dto.setType(product.getType());
			dtoProduct.add(dto);
		}
		return dtoProduct;
		
	}
	

	
// fetch Client
	@Override
	public List<ClientMasterDto> fetchClientMasterList() {
		List<ClientMasterDto> dtoList=new ArrayList<>();
//		List<ProductMaster> dtList = new ArrayList<>();
		List<ClientMaster> clList=clientMasterRepository.findAll();
//		List<ClientMaster> prList = clientMasterRepository.findAll();
		for(ClientMaster client:clList) {
			ClientMasterDto dto=new ClientMasterDto();
			Optional<ProductMaster> ProductOptional = productMasterRepository.findById(client.getPid());
			if(ProductOptional.isPresent()) {
				ProductMaster master = ProductOptional.get();
				dto.setProductname(master.getProductname());
				dto.setProductprice(master.getProductprice());
				dto.setQuantiy(master.getQuantiy());
				dto.setPid(master.getPid());
				dto.setType(master.getType());
			}
			dto.setName(client.getName());
			dto.setEmail(client.getEmail());
			dto.setPhoneno(client.getPhoneno());
			dto.setId(client.getId());
			dto.setAddress(client.getAddress());
			dto.setUserid(client.getUserid());
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	
	
// update Client
	@Override
	public ResponseEntity<String> updateClientMaster(ClientMasterDto clientMasterDto) {
		Optional<ClientMaster> clientOptional = clientMasterRepository.findById(clientMasterDto.getId());
		if(clientOptional.isPresent()) {
		ClientMaster client=clientOptional.get();
		client.setName(clientMasterDto.getName());
		client.setEmail(clientMasterDto.getEmail());
//		client.setPassword(clientMasterDto.getPassword());
		client.setPhoneno(clientMasterDto.getPhoneno());
		client.setAddress(clientMasterDto.getAddress());
//		client.setUserid(clientMasterDto.getUserid());
		clientMasterRepository.save(client);
		 return new ResponseEntity<>(gson.toJson("Successfully data updated"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(gson.toJson("Something went wrong"), HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	// update Product
	@Override
	public ResponseEntity<String> updateProductMaster(ProductMasterDto productMasterDto){
		Optional<ProductMaster> productOptional = productMasterRepository.findById(productMasterDto.getPid());
		if(productOptional.isPresent()) {
			ProductMaster product=productOptional.get();
			product.setProductname(productMasterDto.getProductname());
			product.setProductprice(productMasterDto.getProductprice());
			product.setQuantiy(productMasterDto.getQuantiy());
			product.setType(productMasterDto.getType());
			product.setStatus(1);
			productMasterRepository.save(product);
			return new ResponseEntity<>(gson.toJson("Successfully data updated"), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(gson.toJson("Something went wrong"), HttpStatus.BAD_REQUEST);
	}
	

	
	// soft delete the product
	@Override
	 public void remove(Integer id){
		 Optional<ProductMaster> productOptional = productMasterRepository.findById(id);
		 if(productOptional.isPresent()) {
				ProductMaster product=productOptional.get();
				product.setStatus(0);
				productMasterRepository.save(product);
		 	}
	    }
	
	
	
//	public List<ClientMasterDto> fetchItemMasterList(){
//		List<ProductMasterDto> products = new ArrayList();
//		for(ProductMasterDto cc:products) {
//			ProductMasterDto dto=new ProductMasterDto();
//			dto.setPid(cc.getPid());
//			dto.setProductname(cc.getProductname());
//			dto.setProductprice(cc.getProductprice());
//		}
//	}
//	
//	 public ProductMasterDto getProductMasterBypId(Integer pId) {
//		 ProductMasterDto productMasterDto = products.stream().filter(t -> pId.equals(t.getPid())).findAny().orElse(null);
//				 return productMasterDto;
//		 
//	 }

}
