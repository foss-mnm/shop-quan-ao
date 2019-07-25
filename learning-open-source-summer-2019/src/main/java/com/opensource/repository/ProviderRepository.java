package com.opensource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opensource.model.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long>{

}
