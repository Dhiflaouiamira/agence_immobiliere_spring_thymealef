package com.tekup.agence_Immobilier.services;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.agence_Immobilier.entities.Reservation;
import com.tekup.agence_Immobilier.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired ReservationRepository ReservationRepository;
	
	@Override
	public Reservation saveReservation(Reservation R) {
		
		return ReservationRepository.save(R);
	}

	@Override
	public void deleteBienReservation(Reservation R) {
		ReservationRepository.delete(R);
	}

	@Override
	public Reservation getReservation(Long id) {
		
		return ReservationRepository.findById(id).get();
	}

	@Override
	public List<Reservation> getAllReservation() {
		
		return ReservationRepository.findAll();
	}

}

