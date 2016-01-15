package be.ordina.award.resource;

import org.springframework.hateoas.ResourceSupport;

public class AwardResource extends ResourceSupport {
    private Integer price;

    public AwardResource() {
    }

    public AwardResource(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
