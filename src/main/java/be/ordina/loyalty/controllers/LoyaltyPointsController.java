package be.ordina.loyalty.controllers;

import be.ordina.loyalty.assembler.LoyaltyPointsAssembler;
import be.ordina.loyalty.model.LoyaltyPoints;
import be.ordina.loyalty.repository.LoyaltyPointsRepository;
import be.ordina.loyalty.resources.LoyaltyPointsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/loyaltyPoints")
public class LoyaltyPointsController {

    @Autowired
    LoyaltyPointsRepository loyaltyPointsRepository;

    @Autowired
    LoyaltyPointsAssembler loyaltyPointsAssembler;

    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public HttpEntity<LoyaltyPointsResource> getPoints(@PathVariable Long customerId) {
        LoyaltyPoints loyaltyPoints = loyaltyPointsRepository.getLoyaltyPointsByCustomerId(customerId);

        return ok(loyaltyPointsAssembler.toResource(loyaltyPoints));
    }

}
