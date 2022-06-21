package sk.posam.fsa.projekt.application.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.projekt.domain.Discount;

import java.util.List;

public interface DiscountCrudRepository extends CrudRepository<Discount, Long> {
    List<Discount> findByCode(String code);
}
