package com.Demo.sellingApp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductMasterDto {

	private Integer pid;
	
	@NotEmpty
	private String productname;
	
	@NotNull
	private int productprice;
	
	@NotNull
	private int quantiy;
	
	@NotEmpty
	private String type;

	private Integer status;
	
//	private int buyItem;
	
//	private int total;
	
	
}
