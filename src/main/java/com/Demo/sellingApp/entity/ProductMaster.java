package com.Demo.sellingApp.entity;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="product_master")
public class ProductMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="p_id")
	private Integer pid;
	
	@Column(name="product_name")
	private String productname;
	
	@Column(name="product_price")
	private int productprice;
	
	@Column(name="quantity")
	private int quantiy;
	
//	@Column(name="buy_item")
//	private int buyItem;
	
//	@Column(name="total")
//	private int total;
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private Integer status;
	
	@OneToMany()
	@JoinColumn(name = "p_id", referencedColumnName = "p_id", insertable = false, updatable = false)
	private List<ClientMaster> clientMasters;

	
	
}
