package mx.edu.uacm.centrocomunitario.entity;

import java.util.Date;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class AsistenciaTest {
	private static final Logger log = LogManager.getLogger(AsistenciaTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void debeGuardarActividad(){
		log.debug(">Entrando a debeGuardarAsistencia <");
		
	
		Actividad actividad = new Actividad();
		actividad.setNombre("Canto");
		
		Actividad actividad2 = new Actividad();
		actividad2.setNombre("Guitarra");
		
		
		Centro centro = new Centro();
		centro.setNombre("Centro tlahuac");
		
		
		Centro centro2 = new Centro();
		centro2.setNombre("Centro Ixtapalapa");
		
        User u = new User();
		u.setEdad(23);
		u.setNombre("Benjamin");
		u.setSexo("M");
		u.setTelefono("5565373222");
		u.setApellidoMaterno("Morales");
		u.setApellidoPaterno("Gomez");
		u.setCorreo("mogo@gmail.com");
		u.setDireccion("selene num 43");
		
		User u2 = new User();
		u2.setEdad(21);
		u2.setNombre("Laura");
		u2.setSexo("F");
		u2.setTelefono("5569872233");
		u2.setApellidoMaterno("Perez");
		u2.setApellidoPaterno("Gomez");
		u2.setCorreo("lau@gmail.com");
		u2.setDireccion("tlahuac 14");
		
		Asistencia a1 = new Asistencia();
		Asistencia a2 = new Asistencia();
		
		a1.setActividad(actividad);
		a1.setCentro(centro);
		a1.setUsuario(u);
		Date f1 = new Date();
		a1.setFecha(f1);
		
		a2.setActividad(actividad2);
		a2.setCentro(centro2);
		a2.setUsuario(u2);
		Date f2 = new Date();
		a2.setFecha(f2);
		
		em.persist(a1);
		em.persist(a2);
		em.flush();

	
	}
}