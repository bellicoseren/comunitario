package mx.edu.uacm.centrocomunitario.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


@SpringBootTest
public class ActividadTest {
private static final Logger log = LogManager.getLogger(ActividadTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	public void debeGuardarActividad(){
		log.debug(">Entrando a debeGuardarActividad <");
		
	
		Actividad actividad = new Actividad();
		actividad.setNombre("Guitarra");
		
		Actividad actividad2 = new Actividad();
		actividad2.setNombre("Pintura");
		em.persist(actividad);
		em.persist(actividad2);
		em.flush();

	
	}
}
