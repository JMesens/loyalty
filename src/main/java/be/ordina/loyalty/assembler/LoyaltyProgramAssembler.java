package be.ordina.loyalty.assembler;

import be.ordina.loyalty.controllers.LoyaltyProgramController;
import be.ordina.loyalty.model.LoyaltyProgram;
import be.ordina.loyalty.resources.LoyaltyProgramResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

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
}
