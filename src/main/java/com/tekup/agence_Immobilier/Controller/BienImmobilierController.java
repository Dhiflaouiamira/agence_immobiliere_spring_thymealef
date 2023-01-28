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
import com.tekup.agence_Immobilier.entities.BienImmobilier;


import com.tekup.agence_Immobilier.services.BienImmobilierService;
import com.tekup.agence_Immobilier.services.UserService;





	@Controller
	public class BienImmobilierController {
       
		
		@Autowired 
		UserService userService;
	
		private BienImmobilierService bienImmobilierService;
		
		public BienImmobilierController(BienImmobilierService bienImmobilierService) {
			super();
			this.bienImmobilierService = bienImmobilierService;
		}
		
		
		@GetMapping("/bienImmobiliers")
		public String listBienImmobilier(Model model) {
			List<BienImmobilier> bienImmobiliers=bienImmobilierService.getAllBienImmobiliers();
			model.addAttribute("bienImmobiliers",bienImmobiliers);
			return "bienImmobiliers";
		}
		
		
		
		@GetMapping("/bienImmobiliers/new")
		public String createUserForm(Model model) {
			
			
			
			BienImmobilier bienImmobilier= new BienImmobilier();
			model.addAttribute("bBienImmobilier",bienImmobilier);
			
			
			List<User> users = userService.getAllUsers();
		        model.addAttribute("users", users);
			
			return "Create_BienImmobilier" ;
		}

		
	    @PostMapping("/bienImmobiliers")
	 public String saveBienImmobilier (@ModelAttribute("BienImmobilier") BienImmobilier bienImmobilier) {
	    	bienImmobilierService.saveBienImmobilier(bienImmobilier);
	    	return "redirect:/bienImmobiliers";
	    }
	    
	    
	   
	    @GetMapping("/bienImmobiliers/edit/{id}")
		public String editBienImmobilierForm(@PathVariable Long id,Model model) {
			model.addAttribute("bienImmobilier",bienImmobilierService.getBienImmobilierById(id));
			
          
			
            BienImmobilier bienImmobilier= new BienImmobilier();
			model.addAttribute("BienImmobilier",bienImmobilier);
			
			return "editeBienImmobilier";
		}
	   
	    
	    
	    
	    
	    
	    @PostMapping("/bienImmobiliers/{id}")
	    public String updateBienImmobilier(@PathVariable Long id,
	    	@ModelAttribute("bienImmobilier") BienImmobilier bienImmobilier ,
	    	Model model){
	    		
	    		

	        BienImmobilier existingBienImmobilier = bienImmobilierService.getBienImmobilierById(id);
    		existingBienImmobilier.setId(id);
    		existingBienImmobilier.setName(bienImmobilier.getName());
    
    		existingBienImmobilier.setAddress(bienImmobilier.getAddress());
    		existingBienImmobilier.setNbPieces(bienImmobilier.getNbPieces());
    		existingBienImmobilier.setDescription(bienImmobilier.getDescription());
    		existingBienImmobilier.setImages(bienImmobilier.getImages());
    		existingBienImmobilier.setType(bienImmobilier.getType());
    		
    		 List<User> users = userService.getAllUsers();
    	      model.addAttribute("users", users);
    		    
    		
    		bienImmobilierService.updateBienImmobilier(existingBienImmobilier);
    		return "redirect:/bienImmobiliers";
   
   
   }
	    		
	    
	    
	    

	    
	 

   

    @GetMapping("/bienImmobiliers/{id}")
    public String deletebienImmobilier(@PathVariable Long id) {
    	bienImmobilierService.deleteBienImmobilierById(id);
    	return "redirect:/bienImmobiliers";
    	 
    	
  	    
    
}
}