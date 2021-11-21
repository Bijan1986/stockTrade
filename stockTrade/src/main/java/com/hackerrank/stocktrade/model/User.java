package com.hackerrank.stocktrade.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Bijan Nayak
 *
 */

@Entity(name = "USER")
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "user id can not be null or void")
	private Long id;

	@Column(name = "USER_NAME")
	@NotNull(message = "user name can not be null or void")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userId")
	private List<Trade> trades;

	public User(String name) {
		this.name = name;
	}

	public User(@NotNull(message = "user id can not be null or void") Long id,
			@NotNull(message = "user name can not be null or void") String name) {
		this.id = id;
		this.name = name;
	}

	

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
