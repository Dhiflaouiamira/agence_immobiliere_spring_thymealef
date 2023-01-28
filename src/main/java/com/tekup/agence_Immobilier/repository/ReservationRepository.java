package  com.tekup.agence_Immobilier.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tekup.agence_Immobilier.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
