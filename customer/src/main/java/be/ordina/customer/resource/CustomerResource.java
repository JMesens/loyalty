package be.ordina.customer.resource;

import org.springframework.hateoas.ResourceSupport;

public class CustomerResource extends ResourceSupport {

    private String name;

    public CustomerResource() {
    }

    public CustomerResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
