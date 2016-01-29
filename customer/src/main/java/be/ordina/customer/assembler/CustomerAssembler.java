package be.ordina.customer.assembler;

import be.ordina.customer.controller.CustomerController;
import be.ordina.customer.model.Customer;
import be.ordina.customer.resource.CustomerResource;
import be.ordina.customer.resource.CustomersResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class CustomerAssembler extends ResourceAssemblerSupport<Customer,CustomerResource>{

    public CustomerAssembler() {
        super(CustomerController.class, CustomerResource.class);
    }

    @Override
    public CustomerResource toResource(Customer entity) {
        CustomerResource resource = createResourceWithId(entity.getId(), entity);
        resource.setName(entity.getName());
        return resource;
    }

    public CustomersResource toCustomersResource(Iterable<? extends Customer> entities) {
        List<CustomerResource> customerList = super.toResources(entities);
        CustomersResource resource = new CustomersResource(customerList);

        return resource;
    }
}
