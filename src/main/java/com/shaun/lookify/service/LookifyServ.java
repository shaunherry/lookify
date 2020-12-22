package com.shaun.lookify.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shaun.lookify.models.Lookify;
import com.shaun.lookify.repository.LookifyRepo;

@Service
public class LookifyServ {
	
	@Autowired
	private final LookifyRepo lrepo;
	
	public LookifyServ(LookifyRepo lrepo) {
		this.lrepo = lrepo;
		
	}
	
	public List<Lookify> all(){
		return lrepo.findAll();
		}
	
	public void save(@Valid Lookify song) {
		lrepo.save(song);
	}
	
	public Lookify find(Long id) {
		Optional<Lookify> optionalLookify = lrepo.findById(id);
		if(optionalLookify.isPresent()) {
			return optionalLookify.get();
		} else {
			return null;
		}
	}
	//create a song
		public Lookify create(Lookify lookify) {
			return lrepo.save(lookify);
		}
		
		//delete a song
		public Lookify delete(Long id) {
			lrepo.deleteById(id);
			return null;
		}

		

}
