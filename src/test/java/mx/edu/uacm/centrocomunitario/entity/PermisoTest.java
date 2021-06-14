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
public class PermisoTest {
private static final Logger log = LogManager.getLogger(PermisoTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	public void debeGuardarPermiso(){
		log.debug(">Entrando a debeGuardarPermiso <");
		
	
		Permiso p = new Permiso();
		p.setNombre("lectura");
		
		Permiso p2 = new Permiso();
		p2.setNombre("escritura");
		
		em.persist(p);
		em.persist(p2);
		em.flush();

	
	}
}
