package ar.edu.unq.desapp.grupoo022020.backenddesappapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoo022020.backenddesappapi.model.AdminUser;

@Configuration
@Repository
public interface AdminUserRepository extends CrudRepository<AdminUser, Integer> {

	Optional<AdminUser> findById(Integer id);

	List<AdminUser> findAll();

	Optional<AdminUser> findByNickName(String nickName);

	Optional<AdminUser> findByMail(String mail);

}
