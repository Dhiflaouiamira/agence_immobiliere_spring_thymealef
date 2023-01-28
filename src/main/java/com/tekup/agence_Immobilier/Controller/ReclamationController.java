

package com.tekup.agence_Immobilier.Controller;



import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import com.tekup.agence_Immobilier.entities.BienImmobilier;
import com.tekup.agence_Immobilier.entities.Reclamation;
import com.tekup.agence_Immobilier.entities.User;
import com.tekup.agence_Immobilier.repository.UserRepository;
import com.tekup.agence_Immobilier.services.ReclamationService;

@Controller
public class ReclamationController {
      
	
	@Autowired 
	private UserRepository userRepository ;
	
	@Autowired
	private ReclamationService reclamationService;
	
	public ReclamationController(ReclamationService reclamationService) {
		super();
		this.reclamationService = reclamationService;
	}
	
	
	@GetMapping("/reclamations")
	public String listReservation(Model model) {
		model.addAttribute("reclamations",reclamationService.getAllReclamation());
		return "reclamations";
	}
	
	
	@GetMapping("/reclamations/new")
	public String createReservationForm(Model model) {
		Reclamation reclamation= new Reclamation();
		model.addAttribute("reclamations",reclamation);
			
      List<User> listUsers=userRepository.findAll();
       model.addAttribute("listUsers",listUsers);
       
       
		
		return "Create_reclamation" ;
		
	}
	
	
	  @GetMapping("/reclamations/edit/{id}")
			public String editreclamationForm(@PathVariable Long id,Model model) {
				model.addAttribute("reclamation",reclamationService.getReclamation(id));
				
	          
				
				Reclamation reclamation= new Reclamation();
				model.addAttribute("Reclamation",reclamation);
				
				return "editeReclamation";
			}
		   
		    
		    
		    
		    
		    
		    @PostMapping("/reclamations/{id}")
		    public String updateReclamation(@PathVariable Long id,
		    	@ModelAttribute("reclamation") Reclamation reclamation ,
		    	Model model){
		    		
		    		

		    	Reclamation existingReclamation = reclamationService.getReclamation(id);
	    		existingReclamation.setId(id);
	    	
	    
	    		existingReclamation.setTypeR(reclamation.getTypeR());
	    		existingReclamation.setDescription(reclamation.getDescription());
	    		existingReclamation.setDate(reclamation.getDate());
	    		
	    		reclamationService.updateReclamation(existingReclamation);
	    		return "redirect:/reclamations";
	   
	   
	   }
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    @GetMapping("/reclamations/{id}")
		    public String deletereclamation(@PathVariable Long id) {
		    	reclamationService.deleteReclamationById(id);
		    	return "redirect:/reclamations";
		    	 
		    
		    }
		    
		    

    @PostMapping("/reclamations/save")
 public String saveReservation (@ModelAttribute("reclamation") Reclamation reclamation) {
    	reclamationService.saveReclamation(reclamation);
    	return "redirect:/reclamations";
    }
}



