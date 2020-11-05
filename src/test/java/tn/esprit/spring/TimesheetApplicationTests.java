package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.log4j.Logger;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.services.*;

@SpringBootTest
class TimesheetApplicationTests {
	private static final Logger l = Logger.getLogger(TimesheetApplicationTests.class);
	@Autowired
	IEntrepriseService entrepriseService;
	@Test
	void testAjoutEmployee() {
		int k=0;
		try {
			k=entrepriseService.ajouterEntreprise(new Entreprise("Renault", "Renault SAS"));
		boolean test=(k!=0)?true:false;
		
		assertEquals(test, true,"ajout avec success de l'entreprise");
		
		if(test) {
			l.info("entreprise avec id "+k+" added successfully ");
		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	@Test
	void suppressionEmployee() {
		int nb_avant_suppression=entrepriseService.getNombreEntreprise();

		try {
			System.out.println(nb_avant_suppression);
			entrepriseService.deleteEntrepriseById(2);
			int nb_apres_suppression=entrepriseService.getNombreEntreprise();
			System.out.println(nb_apres_suppression);
			boolean test=(nb_apres_suppression!=nb_avant_suppression)?true:false;
		
		assertEquals(test, true,"supprimee  avec success de lentreprise");
		
		if(test) {
			l.info("entreprise avec id "+2+" deleted  successfully ");
		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}



	
}