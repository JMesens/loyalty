package be.ordina.award.controller;

import be.ordina.award.assembler.AwardAssembler;
import be.ordina.award.entity.Award;
import be.ordina.award.repository.AwardRepository;
import be.ordina.award.resource.AwardResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/award")
public class AwardController {

    @Autowired
    AwardRepository awardRepository;

    @Autowired
    AwardAssembler awardAssembler;

    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    public HttpEntity<Resources<AwardResource>> getAllAwards() {

        return ok(awardAssembler.toAwardResources(awardRepository.findAll()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{awardId}", produces = "application/json")
    public HttpEntity<AwardResource> getAwardById(@PathVariable Long awardId) {
        Award award = awardRepository.findOne(awardId);

        return ok(awardAssembler.toResource(award));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byLoyaltyProgram/{loyaltyProgramId}", produces = "application/json")
    public HttpEntity<Resources<AwardResource>> getAwardsByLoyaltyProgram(@PathVariable Long loyaltyProgramId) {
        List<Award> awards = awardRepository.findAwardsByLoyaltyProgramId(loyaltyProgramId);

        return ok(awardAssembler.toAwardResources(awards));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/eligibleAwards/{loyaltyProgramId}/{points}", produces = "application/json")
    public HttpEntity<Resources<AwardResource>> getEligibleAwards(@PathVariable Long loyaltyProgramId, @PathVariable Integer points) {
        List<Award> awards = awardRepository.findAwardsByLoyaltyProgramIdAndPriceLessThanEqual(loyaltyProgramId, points);

        return ok(awardAssembler.toAwardResources(awards));
    }
}
