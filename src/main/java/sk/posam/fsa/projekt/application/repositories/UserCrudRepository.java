package sk.posam.fsa.projekt.application.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.projekt.domain.Discount;
import sk.posam.fsa.projekt.domain.User;

import java.util.List;

public interface UserCrudRepository extends CrudRepository<User, Long> {
    List<User> findByUsername(String username);
}
