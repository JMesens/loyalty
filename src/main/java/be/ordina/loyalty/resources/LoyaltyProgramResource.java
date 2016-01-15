package be.ordina.loyalty.resources;

import org.springframework.hateoas.ResourceSupport;

public class LoyaltyProgramResource extends ResourceSupport {
    private String name;

    public LoyaltyProgramResource() {
    }

    public LoyaltyProgramResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
