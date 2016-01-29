package be.ordina.loyalty.controllers;

import be.ordina.loyalty.assembler.LoyaltyProgramAssembler;
import be.ordina.loyalty.model.LoyaltyProgram;
import be.ordina.loyalty.repository.LoyaltyProgramRepository;
import be.ordina.loyalty.resources.LoyaltyProgramResource;
import be.ordina.loyalty.resources.LoyaltyProgramsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/")
public class LoyaltyProgramController {

    @Autowired
    LoyaltyProgramRepository loyaltyProgramRepository;

    @Autowired
    LoyaltyProgramAssembler loyaltyProgramAssembler;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public HttpEntity<LoyaltyProgramsResource> getLoyaltyPrograms() {
        List<LoyaltyProgram> loyaltyPrograms = loyaltyProgramRepository.findAll();
        return ok(loyaltyProgramAssembler.toLoyaltyProgramsResource(loyaltyPrograms));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{loyaltyProgramId}")
    public HttpEntity<LoyaltyProgramResource> getLoyaltyProgram(@PathVariable("loyaltyProgramId") Long id) {

        LoyaltyProgram loyaltyProgram = loyaltyProgramRepository.findOne(id);

        return ok(loyaltyProgramAssembler.toResource(loyaltyProgram));
    }

}
