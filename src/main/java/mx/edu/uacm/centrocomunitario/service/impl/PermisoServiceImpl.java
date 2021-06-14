package mx.edu.uacm.centrocomunitario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.centrocomunitario.entity.Permiso;
import mx.edu.uacm.centrocomunitario.repository.PermisoRepository;
import mx.edu.uacm.centrocomunitario.service.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService {

	@Autowired
	private PermisoRepository permisoRepository ;
	
	public Permiso guardarPermiso(Permiso p) {
		// TODO Auto-generated method stub
		return permisoRepository.save(p);
	}
	
	public boolean existePermiso(Long id) {
		boolean existe = false;
		if (permisoRepository.existsById(id)) {
			existe=true;
		}
		return existe;
	}

}