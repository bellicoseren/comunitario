package mx.edu.uacm.centrocomunitario.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import mx.edu.uacm.centrocomunitario.repository.UserRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTest {
	private static final Logger log = LogManager.getLogger(UserTest.class);
	
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private UserRepository userRepository;
	
	
//	@Test
	@Order(1)
	@Transactional
	@Rollback(false)
	public void debeGuardarUsuario(){
		log.debug(">Entrando a debeGuardarUsuario <");
		
	
		User u = new User();
		
		log.debug(">Creo Usuario <");
		u.setEdad(23);
		u.setNombre("Benjamin");
		u.setSexo("F");
		u.setTelefono("5565373222");
		u.setApellidoMaterno("Morales");
		u.setApellidoPaterno("Gomez");
		u.setCorreo("mogo@gmail.com");
		u.setDireccion("selene num 43");
		
		Rol r = new Rol();
		r.setNombre("profesor");
		Rol r2 = new Rol();
		r2.setNombre("administrador");
		Rol r3 = new Rol();
		r3.setNombre("alumno");
		
		List<Rol> roles = new ArrayList<>();
		roles.add(r);
		roles.add(r3);
		u.setRoles(roles);

		
		em.persist(u);
		em.flush();

	
	}
	@Test
	@Order(2)
	public void debeObtenerTodosCursosPaginado() {
		log.debug("Entrando al metodo debeConsultarTodosCursosPaginado");
		Pageable pageable = PageRequest.of(0, 3);
		assertThat(userRepository.findAll());
		assertThat(pageable.getPageNumber()).isEqualTo(0);
		
		Pageable nextPageable = pageable.next();
		assertThat(userRepository.findAll());
		assertThat(nextPageable.getPageNumber()).isEqualTo(1);
		System.out.println(userRepository.toString());
	}
}
