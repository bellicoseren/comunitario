package mx.edu.uacm.centrocomunitario.service;

import org.springframework.stereotype.Component;

import mx.edu.uacm.centrocomunitario.entity.Permiso;
@Component
public interface PermisoService {
	Permiso guardarPermiso(Permiso p);
	boolean existePermiso(Long id);
}
