package com.tekup.agence_Immobilier.services;


	

	import java.util.List;

	import com.tekup.agence_Immobilier.entities.Reservation;

	public interface ReservationService {

		Reservation saveReservation(Reservation R);
		void deleteBienReservation(Reservation R);
		Reservation getReservation(Long id);
		List<Reservation> getAllReservation();
	}


