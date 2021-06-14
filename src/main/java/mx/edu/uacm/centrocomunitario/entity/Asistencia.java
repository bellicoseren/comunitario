package mx.edu.uacm.centrocomunitario.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;



@Data
@Entity
@IdClass(AsistenciaId.class)
public class Asistencia {
	@Id
	@ManyToOne
	@JoinColumn(
			name="centro_id",
			insertable = false, updatable = false
	)	
	private Centro centro;
	
	@Id
	@ManyToOne
	@JoinColumn(
			name="usuario_id",
			insertable = false, updatable = false
	)	
	private User usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(
			name="actividad_id",
			insertable = false, updatable = false
	)	
	private Actividad actividad;
	
	private Date fecha;
	
}
