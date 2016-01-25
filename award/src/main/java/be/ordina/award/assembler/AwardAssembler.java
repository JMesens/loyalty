package be.ordina.award.assembler;

import be.ordina.award.controller.AwardController;
import be.ordina.award.entity.Award;
import be.ordina.award.resource.AwardResource;
import be.ordina.award.resource.AwardsResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class AwardAssembler extends ResourceAssemblerSupport<Award, AwardResource> {
    public AwardAssembler() {
        super(AwardController.class, AwardResource.class);
    }

    @Override
    public AwardResource toResource(Award entity) {
        AwardResource resource = createResourceWithId(entity.getId(), entity);
        resource.setPrice(entity.getPrice());
        resource.setName(entity.getName());
        resource.setLoyaltyProgram(entity.getLoyaltyProgramId());
        resource.add(linkTo(methodOn(AwardController.class).getAwardsByLoyaltyProgram(entity.getLoyaltyProgramId())).withRel("byLoyaltyProgram"));

        return resource;
    }

    public AwardsResource toAwardsResource(Iterable<? extends Award> entities) {
        List<AwardResource> awardsList = super.toResources(entities);
        AwardsResource resource = new AwardsResource((ArrayList<AwardResource>) awardsList);
        resource.add(linkTo(methodOn(AwardController.class).getAllAwards()).withRel("allAwards"));

        return resource;
    }

}
