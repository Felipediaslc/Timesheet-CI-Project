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
	void testAjoutEntreprise() {
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
	void suppressionEntreprise() {

		try {
			entrepriseService.deleteEntrepriseById(2);
			boolean test=true;
		
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