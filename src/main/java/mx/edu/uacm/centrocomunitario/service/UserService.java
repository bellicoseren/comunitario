package mx.edu.uacm.centrocomunitario.service;

import java.util.List;

import org.springframework.data.domain.Page;

import mx.edu.uacm.centrocomunitario.entity.User;


public interface UserService {
	List<User> getAllUser();
	void saveUser(User employee);
	User getUserById(long id);
	void deleteUserById(long id);
	Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
