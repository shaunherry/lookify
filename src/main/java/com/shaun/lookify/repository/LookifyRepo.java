package com.shaun.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shaun.lookify.models.Lookify;

public interface LookifyRepo extends CrudRepository<Lookify, Long>{
	
	List<Lookify> findAll();

}
