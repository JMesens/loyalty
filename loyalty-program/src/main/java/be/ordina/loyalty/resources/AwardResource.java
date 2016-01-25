package be.ordina.loyalty.resources;

import org.springframework.hateoas.ResourceSupport;

public class AwardResource extends ResourceSupport {
    private Integer price;

    private Long loyaltyProgram;

    private String name;

    public AwardResource() {
    }

    public AwardResource(Integer price, Long loyaltyProgram, String name) {
        this.price = price;
        this.loyaltyProgram = loyaltyProgram;
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getLoyaltyProgram() {
        return loyaltyProgram;
    }

    public void setLoyaltyProgram(Long loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
