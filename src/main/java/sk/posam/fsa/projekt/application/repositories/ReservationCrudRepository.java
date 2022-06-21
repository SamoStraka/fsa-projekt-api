package sk.posam.fsa.projekt.application.repositories;

import org.springframework.data.repository.CrudRepository;
import sk.posam.fsa.projekt.domain.Discount;
import sk.posam.fsa.projekt.domain.Reservation;

import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByCourtId(Long id);
    List<Reservation> findByMail(String email);
}
