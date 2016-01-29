package be.ordina.loyalty.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyProgramsResource extends ResourceSupport {

    private List<LoyaltyProgramResource> loyaltyPrograms = new ArrayList<>();

    public LoyaltyProgramsResource() {
    }

    public LoyaltyProgramsResource(List<LoyaltyProgramResource> loyaltyPrograms) {
        this.loyaltyPrograms = loyaltyPrograms;
    }

    public List<LoyaltyProgramResource> getLoyaltyPrograms() {
        return loyaltyPrograms;
    }

    public void setLoyaltyPrograms(List<LoyaltyProgramResource> loyaltyPrograms) {
        this.loyaltyPrograms = loyaltyPrograms;
    }
}