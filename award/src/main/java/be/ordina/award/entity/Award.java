package be.ordina.award.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Award {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long loyaltyProgramId;

    private Integer price;

    public Award() {
    }

    public Award(String name, Long loyaltyProgramId, Integer price) {
        this.name = name;
        this.loyaltyProgramId = loyaltyProgramId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLoyaltyProgramId() {
        return loyaltyProgramId;
    }

    public void setLoyaltyProgramId(Long loyaltyProgramId) {
        this.loyaltyProgramId = loyaltyProgramId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
