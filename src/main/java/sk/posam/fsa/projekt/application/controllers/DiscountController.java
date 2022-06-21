package sk.posam.fsa.projekt.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.projekt.application.repositories.DiscountCrudRepository;
import sk.posam.fsa.projekt.domain.Discount;

import java.util.Optional;

@RestController
@RequestMapping("api/discounts")
public class DiscountController {

    @Autowired
    private DiscountCrudRepository discountRepository;

    //http://localhost:8080/api/discounts/1
    @GetMapping("{id}")
    Discount one(@PathVariable Long id) {
        Optional<Discount> discount = discountRepository.findById(id);
        return discount.orElseThrow(() -> new EntityNotFoundException());
    }

    //http://localhost:8080/api/discounts?code=
    @GetMapping()
    Iterable<Discount> all(@RequestParam(name="code", required = false) String codeFilter) {
        if(codeFilter==null||codeFilter.isBlank()){
            return discountRepository.findAll();
        }
        else{
            return discountRepository.findByCode(codeFilter);
        }
    }

    @PostMapping()
    Discount newDiscount(@RequestBody Discount newDiscount) {
        return discountRepository.save(newDiscount);
    }

    @PutMapping("{id}")
    Discount replaceDiscount(@RequestBody Discount newDiscount, @PathVariable Long id) {

        return discountRepository.findById(id)
                .map(discount -> {
                    discount.setCode(newDiscount.getCode());
                    discount.setPercentage(newDiscount.getPercentage());
                    return discountRepository.save(discount);
                })
                .orElseGet(() -> {
                    newDiscount.setId(id);
                    return discountRepository.save(newDiscount);
                });
    }

    @DeleteMapping("{id}")
    void deleteDiscount(@PathVariable Long id) {
        discountRepository.deleteById(id);
    }
}
