package be.ordina.loyalty.assembler;

import be.ordina.loyalty.controllers.LoyaltyProgramController;
import be.ordina.loyalty.model.LoyaltyProgram;
import be.ordina.loyalty.resources.LoyaltyProgramResource;
import be.ordina.loyalty.resources.LoyaltyProgramsResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class LoyaltyProgramAssembler extends ResourceAssemblerSupport<LoyaltyProgram, LoyaltyProgramResource> {

    public LoyaltyProgramAssembler() {
        super(LoyaltyProgramController.class, LoyaltyProgramResource.class);
    }

    @Override
    public LoyaltyProgramResource toResource(LoyaltyProgram entity) {

        LoyaltyProgramResource resource = createResourceWithId(entity.getId(), entity);
        resource.setName(entity.getName());
        return resource;
    }

    public LoyaltyProgramsResource toLoyaltyProgramsResource(Iterable<? extends LoyaltyProgram> entities) {
        List<LoyaltyProgramResource> awardsList = super.toResources(entities);
        LoyaltyProgramsResource resource = new LoyaltyProgramsResource(awardsList);

        return resource;

    }
}
