package com.tekup.agence_Immobilier.Controller;



	import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;

import com.tekup.agence_Immobilier.entities.BienImmobilier;
import com.tekup.agence_Immobilier.entities.Reservation;
import com.tekup.agence_Immobilier.entities.User;
import com.tekup.agence_Immobilier.repository.BienImmobilierRepository;
import com.tekup.agence_Immobilier.repository.UserRepository;
import com.tekup.agence_Immobilier.services.ReservationService;

	@Controller
	public class ReservationsController {
          
		
		@Autowired 
		private UserRepository userRepository ;
		@Autowired
		private BienImmobilierRepository bienImmobilierRepository ;
		@Autowired
		private ReservationService reservationService;
		
		public ReservationsController(ReservationService reservationService) {
			super();
			this.reservationService = reservationService;
		}
		
		
		@GetMapping("/reservations")
		public String listReservation(Model model) {
			model.addAttribute("reservations",reservationService.getAllReservation());
			return "reservations";
		}
		
		
		@GetMapping("/reservations/new")
		public String createReservationForm(Model model) {
			Reservation reservation= new Reservation();
			model.addAttribute("reservation",reservation);
			
	
			
           List<User> listUsers=userRepository.findAll();
           model.addAttribute("listUsers",listUsers);
           
           
            List<BienImmobilier> listBienImmobiliers=bienImmobilierRepository.findAll();
            model.addAttribute("listBienImmobiliers",listBienImmobiliers);
			
			
			
			
			return "Create_reservation" ;
		}

	    @PostMapping("/reservations")
	 public String saveReservation (@ModelAttribute("reservation") Reservation reservation) {
	    	reservationService.saveReservation(reservation);
	    	return "redirect:/reservations";
	    }
	}


