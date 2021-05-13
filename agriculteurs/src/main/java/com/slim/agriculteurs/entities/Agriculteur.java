package com.slim.agriculteurs.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Agriculteur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idAgriculteur;
@NotNull
@Size (min = 4,max = 15)
private String nomAgriculteur;
@Min(value = 500)
@Max(value = 4000)
private Double salaireAgriculteur;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateEmbauche;
private String nomF;
@ManyToOne
private Ferme ferme;
public Agriculteur() {
super();
}
public Agriculteur(String nomAgriculteur, Double salaireAgriculteur, Date dateEmbauche,String nomF) {
	super();
	
	this.nomAgriculteur = nomAgriculteur;
	this.salaireAgriculteur = salaireAgriculteur;
	this.dateEmbauche = dateEmbauche;
	this.nomF = nomF;
	
}
public Long getIdAgriculteur() {
	return idAgriculteur;
}
public void setIdAgriculteurt(Long idAgriculteur) {
	this.idAgriculteur = idAgriculteur;
}
public String getNomAgriculteur() {
	return nomAgriculteur;
}
public void setNomAgriculteur(String nomAgriculteur) {
	this.nomAgriculteur = nomAgriculteur;
}
public Double getSalaireAgriculteur() {
	return salaireAgriculteur;
}
public void setSalaireAgriculteur(Double salaireAgriculteur) {
	this.salaireAgriculteur = salaireAgriculteur;
}
public Date getDateEmbauche() {
	return dateEmbauche;
}
public void setDateEmbauche(Date dateEmbauche) {
	this.dateEmbauche = dateEmbauche;
}
public String getNomF() {
	return nomF;
}
public void setNomF(String nomF) {
	this.nomF = nomF;
}
@Override
public String toString() {
	return "Agriculteur [idAgriculteur=" + idAgriculteur + ", nomAgriculteur=" + nomAgriculteur
			+ ", salaireAgriculteur=" + salaireAgriculteur + ", dateEmbauche=" + dateEmbauche + "]";
}


}

