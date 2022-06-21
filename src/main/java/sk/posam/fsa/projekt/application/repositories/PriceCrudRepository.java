package sk.posam.fsa.projekt.application.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.projekt.domain.Price;

public interface PriceCrudRepository extends CrudRepository<Price, Long> {
}
