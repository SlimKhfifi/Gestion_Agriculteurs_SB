package com.slim.agriculteurs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.slim.agriculteurs.entities.Agriculteur;

public interface AgriculteurService {
	Agriculteur saveAgriculteur(Agriculteur a);
	Agriculteur updateAgriculteur(Agriculteur a);
void deleteAgriculteur(Agriculteur a);
void deleteAgriculteurById(Long id);
Agriculteur getAgriculteur(Long id);
List<Agriculteur> getAllAgriculteurs();
Page<Agriculteur> getAllAgriculteursParPage(int page, int size);
}
