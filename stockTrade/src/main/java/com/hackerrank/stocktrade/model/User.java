package com.hackerrank.stocktrade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@AllArgsConstructor
@Entity(name = "USER")
public class User {

	@Id
	@Column(name = "USER_ID")
	@NotNull(message = "user id can not be null or void")
	private Long id;

	@Column(name = "USER_NAME")
	@NotNull(message = "user name can not be null or void")
	private String name;

}
