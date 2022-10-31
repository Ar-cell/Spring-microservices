package com.Demo.sellingApp.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="client_master")
public class ClientMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="user_id")
	private int userid;
	
	@Column(name="phoneno")
	private String phoneno;
	
	@Column(name="email")
	private String email;
//	
//	@Column(name="buy_item")
//	private int buyItem;
	
//	private int mou = 25000;
	
//	@Column(name="password")
//	private String password;
	
	@Column(name="address")
	private String address;
	
	@Column(name="p_id")
	private Integer pid;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "p_id", referencedColumnName = "p_id", insertable = false, updatable = false)
	private ProductMaster productMaster;
}
