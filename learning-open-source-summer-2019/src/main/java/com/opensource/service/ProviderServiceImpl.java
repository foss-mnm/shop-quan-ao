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

	@Override
	public Provider getProvider(Long id) {
		// TODO Auto-generated method stub
		return providerRepository.getOne(id);
	}

	@Override
	public void saveProvider(Provider provider) {
		// TODO Auto-generated method stub
		providerRepository.save(provider);
	}

	@Override
	public void deleteProvider(Long id) {
		// TODO Auto-generated method stub
		providerRepository.deleteById(id);;
	}

}
