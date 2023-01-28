package com.tekup.agence_Immobilier.services;



	import java.util.List;


	import com.tekup.agence_Immobilier.entities.BienImmobilier;


	public interface BienImmobilierService {
		
		BienImmobilier saveBienImmobilier(BienImmobilier B);
		
		void deleteBienImmobilierById(Long id);
		BienImmobilier getBienImmobilierById(Long id);
		
		List<BienImmobilier> getAllBienImmobiliers();
		
		BienImmobilier updateBienImmobilier(BienImmobilier B);
	
		

	}

