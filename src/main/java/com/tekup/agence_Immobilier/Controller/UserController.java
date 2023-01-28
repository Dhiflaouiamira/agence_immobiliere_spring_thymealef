package com.tekup.agence_Immobilier.Controller;



	import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import java.util.List;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.tekup.agence_Immobilier.entities.User;

import com.tekup.agence_Immobilier.services.UserService;




	@Controller
	public class UserController {

	
		
		private UserService userService;
		
		public UserController(UserService userService) {
			super();
			this.userService = userService;
		}
		
		
		@GetMapping("/users")
		public String listUser(Model model) {
			List<User> users=userService.getAllUsers();
			model.addAttribute("users",users);
			return "users";
		}
		
		
		
		@GetMapping("/users/new")
		public String createUserForm(Model model) {
			
			
			
			User user= new User();
			model.addAttribute("User",user);
		
			
			return "Create_user" ;
		}

		
	    @PostMapping("/users")
	 public String saveUser (@ModelAttribute("user") User user) {
	    	userService.saveUser(user);
	    	return "redirect:/users";
	    }
	    
	    
	    
	    
	    @GetMapping("/users/edit/{id}")
		public String editUserForm(@PathVariable Long id,Model model) {
			model.addAttribute("user",userService.getUserById(id));
			
           
			
			User user= new User();
			model.addAttribute("User",user);
			
			return "edit_User";
		}
	   
	    @PostMapping("/users/{id}")
	    public String updateUser(@PathVariable Long id,
	    	@ModelAttribute("user") User user ,
	    	Model model){
	    		
	    		
	    		User existingUser = userService.getUserById(id);
	    		existingUser.setId(id);
	    		existingUser.setLastName(user.getLastName());
	    		existingUser.setFirstName(user.getFirstName());
	    		existingUser.setEmail(user.getEmail());
	    		existingUser.setCin(user.getCin());
	    		existingUser.setPrix(user.getPrix());
	    		existingUser.setPhoneNumber(user.getPhoneNumber());
	    		
	    		
	    		userService.updateUser(existingUser);
	    		return "redirect:/users";
	   
	    		
	    	}
	    
	    @GetMapping("/users/{id}")
	    public String deleteUser(@PathVariable Long id) {
	    	userService.deleteUserById(id);
	    	return "redirect:/users";
	    
	    
	    
	    }}


