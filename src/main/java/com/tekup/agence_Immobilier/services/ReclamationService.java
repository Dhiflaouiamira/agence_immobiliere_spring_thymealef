package com.tekup.agence_Immobilier.services;

import java.util.List;

import com.tekup.agence_Immobilier.entities.BienImmobilier;
import com.tekup.agence_Immobilier.entities.Reclamation;

public interface ReclamationService {
	
	Reclamation saveReclamation(Reclamation R);
	void deleteReclamationById(Long id);
	Reclamation getReclamation(Long id);
	List<Reclamation> getAllReclamation();
	Reclamation updateReclamation(Reclamation R);
}


