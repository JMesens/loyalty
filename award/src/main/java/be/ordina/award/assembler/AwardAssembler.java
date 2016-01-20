package be.ordina.award.assembler;

import be.ordina.award.controller.AwardController;
import be.ordina.award.entity.Award;
import be.ordina.award.resource.AwardResource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.List;

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

        return resource;
    }

    public Resources<AwardResource> toAwardResources(Iterable<? extends Award> entities) {
        List<AwardResource> awardsList = super.toResources(entities);
        Resources<AwardResource> awardResources = new Resources<>(awardsList);

        return awardResources;
    }
}
