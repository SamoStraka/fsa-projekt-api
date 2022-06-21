package sk.posam.fsa.projekt.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.projekt.application.repositories.PriceCrudRepository;
import sk.posam.fsa.projekt.domain.Price;
import sk.posam.fsa.projekt.domain.Reservation;

import java.util.Optional;
@RestController
@RequestMapping("api/prices")
public class PriceController {

        @Autowired
        private PriceCrudRepository priceRepository;

        //http://localhost:8080/api/prices/1
        @GetMapping("{id}")
        Price one(@PathVariable Long id) {
            Optional<Price> price = priceRepository.findById(id);
            return price.orElseThrow(() -> new EntityNotFoundException());
        }

        //http://localhost:8080/api/prices
        @GetMapping()
        Iterable<Price> all() {
            return priceRepository.findAll();
        }

        @PostMapping()
        Price newPrice(@RequestBody Price newPrice) {
            return priceRepository.save(newPrice);
        }

        @PutMapping("{id}")
        Price replacePrice(@RequestBody Price newPrice, @PathVariable Long id) {
            return priceRepository.findById(id)
                    .map(price -> {
                        price.setPrice(newPrice.getPrice());
                        price.setCourtType(newPrice.getCourtType());
                        price.setTypeOfDay(newPrice.getTypeOfDay());
                        return priceRepository.save(price);
                    })
                    .orElseGet(() -> {
                        newPrice.setId(id);
                        return priceRepository.save(newPrice);
                    });
        }

        @DeleteMapping("{id}")
        void deleteReservation(@PathVariable Long id) {
            priceRepository.deleteById(id);
        }
}
