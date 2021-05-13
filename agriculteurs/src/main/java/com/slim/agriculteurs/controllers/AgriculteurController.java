package com.slim.agriculteurs.controllers;
import java.text.ParseException;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.slim.agriculteurs.entities.Agriculteur;
import com.slim.agriculteurs.entities.Ferme;
import com.slim.agriculteurs.service.AgriculteurService;
import com.slim.agriculteurs.service.FermeService;

@Controller
public class AgriculteurController {
	@Autowired
	AgriculteurService agriculteurService;
	FermeService fermeService;
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("agriculteur", new Agriculteur());
	return "createAgriculteur";
	}
	
	
	
	
	@RequestMapping("/saveAgriculteur")
	public String saveAgriculteur(@ModelAttribute("Agriculteur") Agriculteur agriculteur)
	{
		agriculteurService.saveAgriculteur(agriculteur);
	return "createAgriculteur";
	}
	

	
	
	@RequestMapping("/ListeAgriculteurs")
	public String listeAgriculteurs(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{ Page<Agriculteur> agrs = agriculteurService.getAllAgriculteursParPage(page, size);
	modelMap.addAttribute("agriculteurs", agrs);
	modelMap.addAttribute("pages", new int[agrs.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeAgriculteurs";
	}
	
	
	@RequestMapping("/supprimerAgriculteur") public String supprimerAgriculteur(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
			{
		    agriculteurService.deleteAgriculteurById(id);
			Page<Agriculteur> agrs = agriculteurService.getAllAgriculteursParPage(page, size);
			modelMap.addAttribute("agriculteurs", agrs);
			modelMap.addAttribute("pages", new int[agrs.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeAgriculteurs";
			}
	
	
	
	@RequestMapping("/modifierAgriculteur")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Agriculteur a= agriculteurService.getAgriculteur(id);
	modelMap.addAttribute("agriculteur", a);
	modelMap.addAttribute("mode", "edit");
	return "editerAgriculteur";
	}
	
	
	@RequestMapping("/updateAgriculteur")
	public String updateAgriculteur(@ModelAttribute("agriculteur") Agriculteur agriculteur,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
		//conversion de la date 
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateEmbauche = dateformat.parse(String.valueOf(date));
		agriculteur.setDateEmbauche(dateEmbauche);
		agriculteurService.updateAgriculteur(agriculteur);
		List<Agriculteur> agrs = agriculteurService.getAllAgriculteurs();
		modelMap.addAttribute("agriculteurs", agrs);
		return "listeAgriculteurs";
		}
	
	
	
	
	
}
