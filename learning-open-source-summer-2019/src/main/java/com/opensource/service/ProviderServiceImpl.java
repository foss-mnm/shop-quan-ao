package com.opensource.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensource.model.Provider;
import com.opensource.repository.ProviderRepository;

@Service
public class ProviderServiceImpl implements ProviderService{

	@Autowired
	private ProviderRepository providerRepository;
	
	@Override
	public List<Provider> loadProviders() {
		// TODO Auto-generated method stub
		return providerRepository.findAll();
	}

}
