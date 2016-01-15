package be.ordina.loyalty.resources;

import org.springframework.hateoas.ResourceSupport;

public class LoyaltyPointsResource extends ResourceSupport {

    private Integer points;

    public LoyaltyPointsResource() {
    }

    public LoyaltyPointsResource(Integer points) {
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
