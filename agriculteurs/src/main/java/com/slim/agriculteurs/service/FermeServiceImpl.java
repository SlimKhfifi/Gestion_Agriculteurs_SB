package com.slim.agriculteurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.slim.agriculteurs.entities.Ferme;

import com.slim.agriculteurs.repos.FermeRepository;

@Service
public class FermeServiceImpl implements FermeService {
@Autowired 
FermeRepository fermeRepository;
@Override
public Ferme saveFerme(Ferme f) {
	return fermeRepository.save(f);
}
@Override
public Ferme updateFerme(Ferme f) {
	return fermeRepository.save(f);
}
@Override
public void deleteFerme(Ferme f) { fermeRepository.delete(f);
}
@Override
public void deleteFermeById(Long id) {
	fermeRepository.deleteById(id);
}
@Override
public Ferme getFerme(Long id) { return fermeRepository.findById(id).get();
}
@Override
public List<Ferme> getAllFermes() { return fermeRepository.findAll();
}
@Override
public Page<Ferme> getAllFermesParPage(int page, int size) {
return fermeRepository.findAll(PageRequest.of(page, size));
}
}
