package sk.posam.fsa.projekt.application.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.projekt.domain.Court;

public interface CourtCrudRepository extends CrudRepository<Court, Long> {
}
