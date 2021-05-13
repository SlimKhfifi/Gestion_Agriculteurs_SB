package com.slim.agriculteurs.service;



import java.util.List;

import org.springframework.data.domain.Page;

import com.slim.agriculteurs.entities.Ferme;

public interface FermeService {
	Ferme saveFerme(Ferme f);
	Ferme updateFerme(Ferme f);
void deleteFerme(Ferme f);
void deleteFermeById(Long id);
Ferme getFerme(Long id);
List<Ferme> getAllFermes();
Page<Ferme> getAllFermesParPage(int page, int size);
}
