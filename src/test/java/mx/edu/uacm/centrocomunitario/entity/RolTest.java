package mx.edu.uacm.centrocomunitario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class RolTest {
	private static final Logger log = LogManager.getLogger(CentroTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void debeGuardarRol(){
		log.debug(">Entrando a debeGuardarRol <");
		Permiso p = new Permiso();
		p.setNombre("lecturaPersonal");
		
		Permiso p2 = new Permiso();
		p2.setNombre("lecturaGeneral");
		
		Permiso p3 = new Permiso();
		p3.setNombre("escritura");
		
	
		Rol r = new Rol();
		r.setNombre("profesor");
		Rol r2 = new Rol();
		r2.setNombre("administrador");
		Rol r3 = new Rol();
		r3.setNombre("alumno");
		
		List<Permiso>permisos = new ArrayList<>();
		permisos.add(p2);
		
		List<Permiso>permisos2 = new ArrayList<>();
		permisos2.add(p2);
		permisos2.add(p3);
		
		List<Permiso>permisos3 = new ArrayList<>();
		permisos3.add(p);
		
		r.setPermisos(permisos);
		r2.setPermisos(permisos2);
		r3.setPermisos(permisos3);
		
		em.persist(r);
		em.persist(r2);
		em.persist(r3);
		em.flush();

	
	}
}
