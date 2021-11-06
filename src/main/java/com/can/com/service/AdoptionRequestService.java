package com.can.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.can.com.model.AdoptionRequest;
import com.can.com.repository.AdoptionRequestRepository;

@Service
public class AdoptionRequestService {
	
	@Autowired
	private AdoptionRequestRepository adoptionRequestRepository;
	
	public List<AdoptionRequest> getAllAdoptionRequestByPet(Long petId) {
		List<AdoptionRequest> adoptionRequestsByPet = new ArrayList<AdoptionRequest>();
		List<AdoptionRequest> adoptionRequests = adoptionRequestRepository.findAll();
		
		for (AdoptionRequest adoptionRequest : adoptionRequests) {
			if(adoptionRequest.getPet().getId() == petId)
				adoptionRequestsByPet.add(adoptionRequest);
		}
		
		return adoptionRequestsByPet;	
	}
}
