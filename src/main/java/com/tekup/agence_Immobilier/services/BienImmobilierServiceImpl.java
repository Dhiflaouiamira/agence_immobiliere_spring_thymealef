package com.tekup.agence_Immobilier.services;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekup.agence_Immobilier.entities.BienImmobilier;

import  com.tekup.agence_Immobilier.repository.BienImmobilierRepository;



@Service
public class BienImmobilierServiceImpl implements BienImmobilierService {

	

	@Autowired
	private BienImmobilierRepository bienImmobilierRepository;
	
	
	
	
	
	@Override
	public BienImmobilier saveBienImmobilier(BienImmobilier B) {
		    
		return bienImmobilierRepository.save(B) ;
	}

	

	@Override
	public BienImmobilier getBienImmobilierById(Long id) {
		
		return bienImmobilierRepository.findById(id).get();
	}

	@Override
	public List<BienImmobilier> getAllBienImmobiliers() {
		
			return bienImmobilierRepository.findAll();
	}

	@Override
	public BienImmobilier updateBienImmobilier(BienImmobilier B) {
	
		return bienImmobilierRepository.save(B);
		
	}


	@Override
	public void deleteBienImmobilierById(Long id) {
		 bienImmobilierRepository.deleteById(id);
		
	}

	


}
