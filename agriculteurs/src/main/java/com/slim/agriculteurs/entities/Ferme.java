package com.slim.agriculteurs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ferme {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idFer;
private String nomFer;
private String descriptionFer;
@OneToMany(mappedBy = "ferme")
private List<Agriculteur> agriculteurs;
public Ferme() {}
public Ferme(String nomFer, String descriptionFer, List<Agriculteur> agriculteurs) {
	super();
	
	this.nomFer = nomFer;
	this.descriptionFer = descriptionFer;
	this.agriculteurs = agriculteurs;
}
public Long getIdFer() {
	return idFer;
}
public void setIdFer(Long idFer) {
	this.idFer = idFer;
}
public String getNomFer() {
	return nomFer;
}
public void setNomFer(String nomFer) {
	this.nomFer = nomFer;
}
public String getDescriptionFer() {
	return descriptionFer;
}
public void setDescriptionFer(String descriptionFer) {
	this.descriptionFer = descriptionFer;
}
public List<Agriculteur> getAgriculteurs() {
	return agriculteurs;
}
public void setAgriculteurs(List<Agriculteur> agriculteurs) {
	this.agriculteurs = agriculteurs;
}
@Override
public String toString() {
	return "Ferme [idFer=" + idFer + ", nomFer=" + nomFer + ", descriptionFer=" + descriptionFer + ", agriculteurs="
			+ agriculteurs + "]";
}


}