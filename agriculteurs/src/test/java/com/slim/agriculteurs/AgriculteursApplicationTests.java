package com.slim.agriculteurs;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.slim.agriculteurs.entities.Agriculteur;
import com.slim.agriculteurs.repos.AgriculteurRepository;

@SpringBootTest
class AgriculteursApplicationTests {

	@Autowired
	private AgriculteurRepository agriculteurRepository;
	@Test
	public void testCreateAgriculteur() {
	Agriculteur agr = new Agriculteur("Ahmed",1100.0,new Date());
	agriculteurRepository.save(agr);
	}
	@Test
	public void testFindAgriculteur()
	{ Agriculteur a = agriculteurRepository.findById(1L).get(); System.out.println(a);
	}
	@Test
	public void testUpdateAgriculteur()
	{ Agriculteur a = agriculteurRepository.findById(1L).get();
	a.setSalaireAgriculteur(1000.0); agriculteurRepository.save(a);
	}
	@Test
	public void testDeleteAgriculteur()
	{ agriculteurRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousAgriculteurs()
	{
	List<Agriculteur> agrs = agriculteurRepository.findAll();
	for (Agriculteur a : agrs)
	{
	System.out.println(a);
	}
	}
}
