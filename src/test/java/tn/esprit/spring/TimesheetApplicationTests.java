package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.*;
import tn.esprit.spring.services.*;

@SpringBootTest
class TimesheetApplicationTests {

	Entreprise em=new Entreprise("nokia","INFO" );
	EntrepriseServiceImpl emp=new EntrepriseServiceImpl();
	private static final Logger l = Logger.getLogger(TimesheetApplicationTests.class);
	@Autowired
	IEntrepriseService entrepriseService;
	@Test
	void testAjoutEntrprise() {
		int k=0;
		try {
			k=entrepriseService.ajouterEntreprise(em);
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
		int nb_avans_suppression=entrepriseService.getEntrepriseById();

		try {
			System.out.println(nb_avans_suppression);
			entrepriseService.deleteEntrepriseById(2);
			int nb_apres_suppression=entrepriseService.getNombreEmployeJPQL();
			System.out.println(nb_apres_suppression);
			boolean test=(nb_apres_suppression!=nb_avans_suppression)?true:false;
		
		assertEquals(test, true,"supprimee  avec success de lemployee");
		
		if(test) {
			l.info("entreprise avec id "+2+" deleted  successfully ");
		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
