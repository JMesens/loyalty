package be.ordina.customer.assembler;

import be.ordina.customer.controller.CustomerController;
import be.ordina.customer.model.Customer;
import be.ordina.customer.resource.CustomerResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

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
}
