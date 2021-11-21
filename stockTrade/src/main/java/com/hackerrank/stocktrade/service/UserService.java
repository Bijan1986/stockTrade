package com.hackerrank.stocktrade.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.stocktrade.model.User;
import com.hackerrank.stocktrade.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

//	public List<User> getAllTradesByUserId(Long id) {
//		return userRepository.findAllById(id);
//	}

}
