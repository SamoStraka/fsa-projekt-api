package sk.posam.fsa.projekt.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.projekt.application.repositories.ReservationCrudRepository;
import sk.posam.fsa.projekt.domain.Discount;
import sk.posam.fsa.projekt.domain.Reservation;

import java.util.Optional;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    @Autowired
    private ReservationCrudRepository reservationRepository;

    //http://localhost:8080/api/reservations?email=?
    @GetMapping()
    Iterable<Reservation> all(@RequestParam(name="email", required = false) String mailFilter) {
        if(mailFilter==null || mailFilter.isEmpty()){
            return reservationRepository.findAll();
        }
        else{
            return reservationRepository.findByMail(mailFilter);
        }
    }

    //http://localhost:8080/reservations/1
    @GetMapping("{id}")
    Reservation one(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.orElseThrow(() -> new EntityNotFoundException());
    }

//    //http://localhost:8080/v1/reservations
//    @GetMapping()
//    Iterable<Reservation> all() {
//        return reservationRepository.findAll();
//    }

    @PostMapping()
    Reservation newReservation(@RequestBody Reservation newReservation) {
        return reservationRepository.save(newReservation);
    }

    @PutMapping("{id}")
    Reservation replaceReservation(@RequestBody Reservation newReservation, @PathVariable Long id) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservation.setMail(newReservation.getMail());
                    reservation.setPrice(newReservation.getPrice());
                    reservation.setDate(newReservation.getDate());
                    reservation.setLength(newReservation.getLength());
                    reservation.setTimeStart(newReservation.getTimeStart());
                    reservation.setStatus(newReservation.getStatus());
                    reservation.setLight(newReservation.isLight());
                    reservation.setCourt(newReservation.getCourt());
                    return reservationRepository.save(reservation);
                })
                .orElseGet(() -> {
                    newReservation.setId(id);
                    return reservationRepository.save(newReservation);
                });
    }

    @DeleteMapping("{id}")
    void deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
    }
}
