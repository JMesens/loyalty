package be.ordina.loyalty.assembler;

import be.ordina.loyalty.controllers.LoyaltyPointsController;
import be.ordina.loyalty.controllers.LoyaltyProgramController;
import be.ordina.loyalty.model.LoyaltyPoints;
import be.ordina.loyalty.resources.AwardsResource;
import be.ordina.loyalty.resources.EligibleAwards;
import be.ordina.loyalty.resources.LoyaltyPointsResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class LoyaltyPointsAssembler extends ResourceAssemblerSupport<LoyaltyPoints, LoyaltyPointsResource> {

    public LoyaltyPointsAssembler() {
        super(LoyaltyPointsController.class, LoyaltyPointsResource.class);
    }

    @Autowired
    EligibleAwards client;

    @Override
    public LoyaltyPointsResource toResource(LoyaltyPoints entity) {
        LoyaltyPointsResource resource = createResourceWithId(entity.getId(), entity);
        resource.setPoints(entity.getPoints());
        resource.setCustomerId(entity.getCustomerId());

        AwardsResource awards = client.getEligibleAwards(entity.getLoyaltyProgram().getId(), entity.getPoints());
        resource.setEligibleAwards(awards.getAwards());

        resource.add(linkTo(methodOn(LoyaltyProgramController.class).getLoyaltyProgram(entity.getLoyaltyProgram().getId())).withRel("loyaltyProgram"));
        resource.add(linkTo(methodOn(LoyaltyPointsController.class).updatePoints(entity.getCustomerId(), null)).withRel("updatePoints"));

        return resource;
    }

}
