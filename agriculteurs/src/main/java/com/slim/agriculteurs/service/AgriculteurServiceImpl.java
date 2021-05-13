package com.slim.agriculteurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.slim.agriculteurs.entities.Agriculteur;
import com.slim.agriculteurs.repos.AgriculteurRepository;

@Service
public class AgriculteurServiceImpl implements AgriculteurService {
@Autowired 
AgriculteurRepository agriculteurRepository;
@Override
public Agriculteur saveAgriculteur(Agriculteur a) {
	return agriculteurRepository.save(a);
}
@Override
public Agriculteur updateAgriculteur(Agriculteur a) {
	return agriculteurRepository.save(a);
}
@Override
public void deleteAgriculteur(Agriculteur a) { agriculteurRepository.delete(a);
}
@Override
public void deleteAgriculteurById(Long id) {
agriculteurRepository.deleteById(id);
}
@Override
public Agriculteur getAgriculteur(Long id) { return agriculteurRepository.findById(id).get();
}
@Override
public List<Agriculteur> getAllAgriculteurs() { return agriculteurRepository.findAll();
}
@Override
public Page<Agriculteur> getAllAgriculteursParPage(int page, int size) {
return agriculteurRepository.findAll(PageRequest.of(page, size));
}
}