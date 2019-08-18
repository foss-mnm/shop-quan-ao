package com.opensource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensource.model.ImportProduct;
import com.opensource.repository.ImportRepository;

@Service
public class ImportSeviceImpl implements ImportService {
	@Autowired
	private ImportRepository importRepository;

	@Override
	public void deleteImport(Long id) {
		importRepository.deleteById(id);
	}

	@Override
	public ImportProduct findOne(Long id) {
		return importRepository.getOne(id);
	}

}
