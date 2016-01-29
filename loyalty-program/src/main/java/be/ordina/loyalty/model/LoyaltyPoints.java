package be.ordina.loyalty.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LoyaltyPoints {
    @Id
    @GeneratedValue
    private Long id;

    private Long customerId;

    @ManyToOne
    private LoyaltyProgram loyaltyProgram;

    private Integer points;

    public LoyaltyPoints() {
    }

    public LoyaltyPoints(Long customerId, LoyaltyProgram loyaltyProgram, Integer points) {
        this.customerId = customerId;
        this.loyaltyProgram = loyaltyProgram;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LoyaltyProgram getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
