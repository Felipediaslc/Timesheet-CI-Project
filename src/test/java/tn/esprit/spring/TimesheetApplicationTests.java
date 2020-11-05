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
	IEmployeService employeService;
	@Test
	void testAjoutEmployee() {
		int k=0;
		try {
			k=employeService.addOrUpdateEmploye(new Employe("example_nom", "example_prenom", "addresse@mail.com", "pass1234", false, Role.ADMINISTRATEUR));
		boolean test=(k!=0)?true:false;
		
		assertEquals(true, true,"ajout avec success de lemployee");
		
		if(test) {
			l.info("employee avec id "+k+" added successfully ");
		}
		} catch (Exception e) {
			// TODO: handle exception
			l.error(e);
		}
	}

	@Test
	void suppressionEmployee() {
		int nb_avans_suppression=employeService.getNombreEmployeJPQL();

		try {
			System.out.println(nb_avans_suppression);
			employeService.deleteEmployeById(12);
			int nb_apres_suppression=employeService.getNombreEmployeJPQL();
			System.out.println(nb_apres_suppression);
			boolean test=(nb_apres_suppression!=nb_avans_suppression)?true:false;
		
		assertEquals(test, true,"supprimee  avec success de lemployee");
		
		if(test) {
			l.info("employee avec id "+12+" deleted  successfully ");
		}
		} catch (Exception e) {
			// TODO: handle exception
			l.error(e)
		}
	}

	

	
}
