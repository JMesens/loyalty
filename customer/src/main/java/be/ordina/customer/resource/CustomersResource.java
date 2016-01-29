package be.ordina.customer.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

public class CustomersResource extends ResourceSupport {

    private List<CustomerResource> customers = new ArrayList<>();

    public CustomersResource() {
    }

    public CustomersResource(List<CustomerResource> customers) {
        this.customers = customers;
    }

    public List<CustomerResource> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerResource> customers) {
        this.customers = customers;
    }
}
