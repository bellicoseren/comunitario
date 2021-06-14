package mx.edu.uacm.centrocomunitario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.uacm.centrocomunitario.entity.Rol;
import mx.edu.uacm.centrocomunitario.repository.RolRepository;
import mx.edu.uacm.centrocomunitario.service.RolService;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository ;
	
	public Rol guardarRol(Rol r) {
		// TODO Auto-generated method stub
		return rolRepository.save(r);
	}

	public boolean existeRol(Long id) {
		boolean existe = false;
		if (rolRepository.existsById(id)) {
			existe=true;
		}
		return existe;
	} 
}