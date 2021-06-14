package mx.edu.uacm.centrocomunitario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.edu.uacm.centrocomunitario.entity.Rol;

@Repository
public interface RolRepository  extends CrudRepository<Rol, Long> {

}
