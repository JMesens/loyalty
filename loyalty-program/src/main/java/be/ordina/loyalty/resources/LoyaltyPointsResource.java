package be.ordina.loyalty.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.Collection;

public class LoyaltyPointsResource extends ResourceSupport {

    private Integer points;
    private Long customerId;

    private Collection<AwardResource> eligibleAwards = new ArrayList<>();

    public LoyaltyPointsResource() {
    }

    public LoyaltyPointsResource(Integer points, Long customerId, Collection<AwardResource> eligibleAwards) {
        this.points = points;
        this.customerId = customerId;
        this.eligibleAwards = eligibleAwards;
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

    public Collection<AwardResource> getEligibleAwards() {
        return eligibleAwards;
    }

    public void setEligibleAwards(Collection<AwardResource> eligibleAwards) {
        this.eligibleAwards = eligibleAwards;
    }
}
