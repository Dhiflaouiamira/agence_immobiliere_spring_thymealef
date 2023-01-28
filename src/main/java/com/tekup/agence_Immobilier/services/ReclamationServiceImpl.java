package com.tekup.agence_Immobilier.services;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.agence_Immobilier.entities.BienImmobilier;
import com.tekup.agence_Immobilier.entities.Reclamation;
import com.tekup.agence_Immobilier.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService{

	@Autowired private ReclamationRepository reclamationRepository;
	
	@Override
	public Reclamation saveReclamation(Reclamation R) {
		
		return reclamationRepository.save(R);
	}

	@Override
	public void deleteReclamationById(Long id) {
		reclamationRepository.deleteById(id);
		
	}

	@Override
	public Reclamation getReclamation(Long id) {
		
		return reclamationRepository.findById(id).get();
	}

	@Override
	public List<Reclamation> getAllReclamation() {
		
	 return reclamationRepository.findAll();
	}

	@Override
	public Reclamation updateReclamation(Reclamation R) {
	
		return reclamationRepository.save(R) ;
	}

}

