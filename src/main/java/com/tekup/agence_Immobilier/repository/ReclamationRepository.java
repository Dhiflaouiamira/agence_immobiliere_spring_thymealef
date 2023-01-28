package  com.tekup.agence_Immobilier.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tekup.agence_Immobilier.entities.Reclamation;
import com.tekup.agence_Immobilier.entities.User;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
	  @Query("SELECT u FROM User u WHERE u.email = ?1")
	    public User findByEmail(String email);
	     
	}

