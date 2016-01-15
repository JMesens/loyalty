package be.ordina.loyalty.assembler;

import be.ordina.loyalty.controllers.LoyaltyPointsController;
import be.ordina.loyalty.controllers.LoyaltyProgramController;
import be.ordina.loyalty.model.LoyaltyPoints;
import be.ordina.loyalty.resources.LoyaltyPointsResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class LoyaltyPointsAssembler extends ResourceAssemblerSupport<LoyaltyPoints, LoyaltyPointsResource> {

    public LoyaltyPointsAssembler() {
        super(LoyaltyPointsController.class, LoyaltyPointsResource.class);
    }

    @Override
    public LoyaltyPointsResource toResource(LoyaltyPoints entity) {
        LoyaltyPointsResource resource = createResourceWithId(entity.getId(), entity);
        resource.setPoints(entity.getPoints());
        resource.add(linkTo(methodOn(LoyaltyProgramController.class).getLoyaltyProgram(entity.getId())).withRel("loyaltyProgram"));

        return resource;
    }

}
