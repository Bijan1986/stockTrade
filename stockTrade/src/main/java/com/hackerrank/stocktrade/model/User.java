package com.hackerrank.stocktrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Bijan Nayak
 *
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "USER")
public class User {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull(message = "user id can not be null or void")
	private Long id;

	@Column(name = "USER_NAME")
	@NotNull(message = "user name can not be null or void")
	private String name;

	public User(String name) {
		this.name = name;
	}

	public User(@NotNull(message = "user id can not be null or void") Long id,
			@NotNull(message = "user name can not be null or void") String name) {
		this.id = id;
		this.name = name;
	}
	
	
	

}
