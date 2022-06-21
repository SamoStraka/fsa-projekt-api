package sk.posam.fsa.projekt.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.projekt.application.repositories.CourtCrudRepository;
import sk.posam.fsa.projekt.domain.Court;
import java.util.Optional;

@RestController
@RequestMapping("api/courts")
public class CourtController {

    @Autowired
    private CourtCrudRepository courtRepository;

    //http://localhost:8080/api/courts/1
    @GetMapping("{id}")
    Court one(@PathVariable Long id) {
        Optional<Court> court = courtRepository.findById(id);
        return court.orElseThrow(() -> new EntityNotFoundException());
    }

    //http://localhost:8080/api/courts
    @GetMapping()
    Iterable<Court> all() {
        return courtRepository.findAll();
    }

}
