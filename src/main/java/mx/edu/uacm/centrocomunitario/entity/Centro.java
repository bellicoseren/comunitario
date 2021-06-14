package mx.edu.uacm.centrocomunitario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Centro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String nombre;
		
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Actividad> actividades2 = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<User> usuarios2 = new ArrayList<>();
	
	
	  @OneToMany(mappedBy = "centro", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Asistencia> usuarios = new ArrayList<>();
	  
	  @OneToMany(mappedBy = "centro", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Asistencia> actividades = new ArrayList<>();
}
