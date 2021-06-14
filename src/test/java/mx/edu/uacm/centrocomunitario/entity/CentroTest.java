package mx.edu.uacm.centrocomunitario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.repository.query.Param;
import org.springframework.test.annotation.Rollback;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CentroTest {
	private static final Logger log = LogManager.getLogger(CentroTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Test
	@Order(1)
	@Transactional
	@Rollback(false)
	public void debeGuardarCentro(){
		log.debug(">Entrando a debeGuardarCentro <");
		
	
		Actividad actividad = new Actividad();
		actividad.setNombre("Canto");
		
		Actividad actividad2 = new Actividad();
		actividad2.setNombre("Guitarra");
		
		List<Actividad> actividades = new ArrayList<>();
		actividades.add(actividad);
		actividades.add(actividad2);
		
		Centro centro = new Centro();
		centro.setNombre("Centro tlahuac");
		centro.setActividades2(actividades);
		
		List<Actividad> actividades2 = new ArrayList<>();
		actividades2.add(actividad);
		
		Centro centro2 = new Centro();
		centro2.setNombre("Centro Ixtapalapa");
		centro2.setActividades2(actividades2);
		
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
		
		List<User> users1 = new ArrayList<>();
		List<User> users2 = new ArrayList<>();
		users1.add(u);
		users1.add(u2);
		users2.add(u2);
		
		centro.setUsuarios2(users1);
		centro2.setUsuarios2(users2);
		
		em.persist(centro);
		em.persist(centro2);
		em.flush();

	
	}
	
	@Test
	@Order(2)
	public void debeObtenerCentrosActividades() {
		
		TypedQuery<Centro> sql =
			      em.createQuery("SELECT c FROM Centro c", Centro.class);
		List<Centro> c = sql.getResultList();
		int i =c.size();
		System.out.println(c.get(0).getNombre());
		System.out.println(c.get(1).getNombre());
		i=i-1;
		System.out.println(i);
		while(i >= 0) {
			System.out.println(c.get(i).getNombre());
			i--;
		}
		
		
	}
	
	
}
