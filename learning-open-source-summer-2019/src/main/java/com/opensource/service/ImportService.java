package com.opensource.service;

import com.opensource.model.ImportProduct;

public interface ImportService {

	ImportProduct findOne(Long id);

	void deleteImport(Long id);
}
