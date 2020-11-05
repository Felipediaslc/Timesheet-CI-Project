package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.controller.ControllerEmployeImpl;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.TimesheetServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetApplicationTests {

	@Autowired 
	IEmployeService ems;
	
	@Autowired
	EmployeRepository employeRepository;
	
	@Autowired
	MissionRepository missionRepository;
	
	@Autowired
	DepartementRepository deptRepoistory;
	
	@Autowired
	TimesheetRepository timesheetRepository;
	TimesheetServiceImpl tmp = new TimesheetServiceImpl();

	private static Logger log = Logger.getLogger(TimesheetApplicationTests.class);

	
	@Test
	public void testAddMission() {
		try {
			
		//	Mission M =;
		//	System.out.println("spot me 1");
			//int Mid= tmp.ajouterMission(M);//the int returned is NULL 
			Mission Mt= missionRepository.save(new Mission("MissionT","mission de test1"));
			System.out.println("spot me 2 "+Mt.getId());
			assertNotEquals("Ajout mission echoué!",0, Mt.getId());
			System.out.println("spot me 3");
			if(Mt.getId() != 0)
				log.info("ajout mission "+Mt.getId()+" réussie ");
		
		} catch (Exception e) {

			log.debug(e);
			log.info("HUDS.TestAddM: an exception has occured!");

		}
	}
	
	@Test
	public void testAddTimesheet() {
	 try {
		 	String dateD="30/10/2020";
		 	String dateF="31/12/2020";		 	
			Date dateDebut=new SimpleDateFormat("dd/MM/yyyy").parse(dateD);
			Date dateFin=new SimpleDateFormat("dd/MM/yyyy").parse(dateF);
			
			Mission M =new Mission("MissionT2","mission de test2");
			Mission Mt= missionRepository.save(M);
			Optional<Employe> em= employeRepository.findById(3);
			
			long current = timesheetRepository.count(); 
			System.out.println("id:"+Mt.getId()+" count: "+current);
			timesheetRepository.save(new Timesheet(new TimesheetPK(Mt.getId(), 3, dateDebut, dateFin), Mt,em.get(), false)) ;
			//
			assertEquals((current +1), timesheetRepository.count());
			if((current +1)== timesheetRepository.count())
				log.info("=> ajout Timesheet réussie ");
		
		} catch (Exception e) {

			log.debug(e);
			log.info("HUDS.TestAddT: an exception has occured!");
		}
		
	}
	
	
}
