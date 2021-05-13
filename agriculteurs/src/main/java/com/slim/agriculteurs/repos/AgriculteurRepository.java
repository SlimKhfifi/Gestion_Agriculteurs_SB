package com.slim.agriculteurs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slim.agriculteurs.entities.Agriculteur;

public interface AgriculteurRepository extends JpaRepository<Agriculteur, Long> {

}
