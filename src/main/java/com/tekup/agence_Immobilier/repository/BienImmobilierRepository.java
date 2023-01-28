package  com.tekup.agence_Immobilier.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

import com.tekup.agence_Immobilier.entities.BienImmobilier;

@Repository
public interface BienImmobilierRepository extends JpaRepository<BienImmobilier, Long>{

}
