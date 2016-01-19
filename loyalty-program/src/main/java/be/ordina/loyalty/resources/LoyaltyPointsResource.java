package be.ordina.loyalty.resources;

import org.springframework.hateoas.ResourceSupport;

public class LoyaltyPointsResource extends ResourceSupport {

    private Integer points;
    private Long customerId;

    public LoyaltyPointsResource() {
    }

    public LoyaltyPointsResource(Integer points, Long customerId) {
        this.points = points;
        this.customerId = customerId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
