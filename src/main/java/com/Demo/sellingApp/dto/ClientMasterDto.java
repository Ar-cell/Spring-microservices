package com.Demo.sellingApp.dto;


import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientMasterDto {

	private Integer id;
	
	@NotEmpty(message="name cann't be empty")
	private String name;
	
	private int userid;
	
	@NotEmpty
	private String phoneno;
	
	@NotEmpty
	private String email;
	
//	private String password;
	
	@NotEmpty
	private String address;
	
	private Integer pid;
	
//	private int buyItem;
	
//	private int mou;
	
	
	private String productname;
	
	private long productprice;
	
	private int quantiy;
	
	private String type;
}
