package mx.edu.uacm.centrocomunitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.uacm.centrocomunitario.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
