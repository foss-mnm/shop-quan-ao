package com.opensource.service;

import java.util.List;

import com.opensource.model.Provider;

public interface ProviderService {

	List<Provider> loadProviders();
	
	Provider getProvider(Long id);
	
	void saveProvider(Provider provider);
	
	void deleteProvider(Long id);
}
