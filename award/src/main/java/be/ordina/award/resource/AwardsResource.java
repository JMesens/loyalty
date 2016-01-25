package be.ordina.award.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;

public class AwardsResource extends ResourceSupport{

    private ArrayList<AwardResource> awards = new ArrayList<>();

    public AwardsResource() {
    }

    public AwardsResource(ArrayList<AwardResource> awards) {
        this.awards = awards;
    }

    public ArrayList<AwardResource> getAwards() {
        return awards;
    }

    public void setAwards(ArrayList<AwardResource> awards) {
        this.awards = awards;
    }
}
