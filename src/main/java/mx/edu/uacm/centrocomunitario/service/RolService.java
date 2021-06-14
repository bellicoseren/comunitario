package mx.edu.uacm.centrocomunitario.service;


import mx.edu.uacm.centrocomunitario.entity.Rol;

public interface RolService {
	Rol guardarRol(Rol r);
	boolean existeRol(Long id);
}
