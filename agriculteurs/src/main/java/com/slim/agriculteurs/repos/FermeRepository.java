package com.slim.agriculteurs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.agriculteurs.entities.Ferme;

public interface FermeRepository extends JpaRepository<Ferme, Long> {

}
