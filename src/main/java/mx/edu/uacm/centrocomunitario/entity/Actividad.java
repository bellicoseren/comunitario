package mx.edu.uacm.centrocomunitario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Actividad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private Long id;
		
	private String nombre;
	
	 @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Asistencia> usuarios = new ArrayList<>();
	  
	  @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Asistencia> centros = new ArrayList<>();
}
