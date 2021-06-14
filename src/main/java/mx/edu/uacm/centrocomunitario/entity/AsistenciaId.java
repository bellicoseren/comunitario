package mx.edu.uacm.centrocomunitario.entity;

import java.io.Serializable;


import lombok.Data;

@Data
public class AsistenciaId implements Serializable {
private static final long serialVersionUID = 1L;
	
	
	private Long centro;
	private Long usuario;
	private Long actividad;
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		return result;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsistenciaId other = (AsistenciaId) obj;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		return true;
	}*/
}
