package be.ordina.loyalty.controllers;

import be.ordina.loyalty.assembler.LoyaltyPointsAssembler;
import be.ordina.loyalty.model.LoyaltyPoints;
import be.ordina.loyalty.repository.LoyaltyPointsRepository;
import be.ordina.loyalty.resources.LoyaltyPointsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST,value = "/{customerId}/updatePoints")
    public ResponseEntity<Void> updatePoints(@PathVariable Long customerId, @RequestBody Integer points){
        LoyaltyPoints loyaltyPoints = loyaltyPointsRepository.getLoyaltyPointsByCustomerId(customerId);
        loyaltyPoints.setPoints(points);
        loyaltyPointsRepository.save(loyaltyPoints);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
