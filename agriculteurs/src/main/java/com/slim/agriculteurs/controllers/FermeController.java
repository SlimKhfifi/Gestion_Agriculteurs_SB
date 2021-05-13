package com.slim.agriculteurs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.slim.agriculteurs.entities.Ferme;
import com.slim.agriculteurs.service.FermeService;

@Controller
public class FermeController {
	@Autowired
	FermeService fermeService;
	
	
	@RequestMapping("/showCreate1")
	public String showCreate1(ModelMap modelMap)
	{
	modelMap.addAttribute("ferme", new Ferme());
	return "createFerme";
	}
	
	
	
	
	@RequestMapping("/saveFerme")
	public String saveFerme(@ModelAttribute("Ferme") Ferme ferme)
	{
		fermeService.saveFerme(ferme);
	return "createFerme";
	}
	
	
	@RequestMapping("/ListeFermes")
	public String listeFermes(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{ Page<Ferme> fers = fermeService.getAllFermesParPage(page, size);
	modelMap.addAttribute("fermes", fers);
	modelMap.addAttribute("pages", new int[fers.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeFermes";
	}
	
	
	@RequestMapping("/supprimerFerme") public String supprimerFerme(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
			{
		    fermeService.deleteFermeById(id);
			Page<Ferme> fers = fermeService.getAllFermesParPage(page, size);
			modelMap.addAttribute("fermes", fers);
			modelMap.addAttribute("pages", new int[fers.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeFermes";
			}
	
	
	
	@RequestMapping("/modifierFerme")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Ferme f= fermeService.getFerme(id);
	modelMap.addAttribute("ferme", f);
	modelMap.addAttribute("mode", "edit");
	return "editerFerme";
	}
	
	
	@RequestMapping("/updateFerme")
	public String updateFerme(@ModelAttribute("Ferme") Ferme ferme,ModelMap modelMap) throws ParseException 
	{
		
		
		
		
		fermeService.updateFerme(ferme);
		List<Ferme> fers = fermeService.getAllFermes();
		modelMap.addAttribute("agriculteurs", fers);
		return "listeFermes";
		}
	
	
}