package be.ordina.award.controller;

import be.ordina.award.assembler.AwardAssembler;
import be.ordina.award.entity.Award;
import be.ordina.award.repository.AwardRepository;
import be.ordina.award.resource.AwardResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/award")
public class AwardController {

    @Autowired
    AwardRepository awardRepository;

    @Autowired
    AwardAssembler awardAssembler;

    @RequestMapping(method = RequestMethod.GET,value = "/{awardId}")
    public HttpEntity<AwardResource> getAwardById(@PathVariable Long awardId){
        Award award = awardRepository.findOne(awardId);

        return ok(awardAssembler.toResource(award));
    }
}
