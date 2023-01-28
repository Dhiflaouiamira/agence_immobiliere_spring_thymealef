package com.tekup.agence_Immobilier.services;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.agence_Immobilier.entities.User;
import com.tekup.agence_Immobilier.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserRepository userRepository;
	
	@Override
	public User saveUser(User U) {
		return userRepository.save(U);
	}

	

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		
	 return userRepository.findAll();
	}

	@Override
	public User updateUser(User U) {
		return userRepository.save(U);
		
	}



	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}




}

