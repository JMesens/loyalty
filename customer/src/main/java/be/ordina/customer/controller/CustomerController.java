package be.ordina.customer.controller;

import be.ordina.customer.assembler.CustomerAssembler;
import be.ordina.customer.model.Customer;
import be.ordina.customer.repository.CustomerRepository;
import be.ordina.customer.resource.CustomerResource;
import be.ordina.customer.resource.CustomersResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerAssembler customerAssembler;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public HttpEntity<CustomersResource> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return ok(customerAssembler.toCustomersResource(customers));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public HttpEntity<CustomerResource> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerRepository.findOne(customerId);
        return ok(customerAssembler.toResource(customer));
    }
}
