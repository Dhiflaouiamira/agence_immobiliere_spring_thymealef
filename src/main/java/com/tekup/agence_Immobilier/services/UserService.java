package com.tekup.agence_Immobilier.services;



	import java.util.List;

	


import com.tekup.agence_Immobilier.entities.User;

	public interface UserService {
		

		User saveUser(User U);
		void deleteUserById(Long id);
		List<User> getAllUsers();
		User updateUser(User U);
		User getUserById(Long id);
	}
 
		
