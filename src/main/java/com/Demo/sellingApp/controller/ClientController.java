package com.Demo.sellingApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.sellingApp.config.Response;
import com.Demo.sellingApp.dto.ClientMasterDto;
import com.Demo.sellingApp.service.ClientMasterService;

@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientMasterService clientMasterService;
	
	@PostMapping("/save_client")
	public Response saveClients(@Valid @RequestBody ClientMasterDto clientMasterDto) {
		return clientMasterService.saveClients(clientMasterDto);
	}
	
	
	
	@GetMapping("/client")
	public List<ClientMasterDto> fetchClientMasterList(){
		return clientMasterService.fetchClientMasterList();
	}
	
	
	@PutMapping("/client")
	public ResponseEntity<String> updateClientMaster(@Valid @RequestBody ClientMasterDto clientMasterDto ){
		return clientMasterService.updateClientMaster(clientMasterDto);
	}
	
}
