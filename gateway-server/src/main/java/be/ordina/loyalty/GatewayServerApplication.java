package be.ordina.loyalty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.BasicLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.BasicLinkBuilder.linkToCurrentMapping;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.ResponseEntity.ok;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

    @RequestMapping("/")
    public HttpEntity<ResourceSupport> index() {

        ResourceSupport resource = new ResourceSupport();
        String self = linkToCurrentMapping().toString();
        resource.add(new Link(self + "/loyaltyPrograms/loyaltyPoints/{id}").withRel("loyaltyPoints"));
        resource.add(new Link(self + "/loyaltyPrograms/{id}").withRel("loyaltyProgram"));
        resource.add(new Link(self + "/awards/").withRel("awards"));
        resource.add(new Link(self + "/awards/{id}").withRel("award"));
        resource.add(new Link(self + "/awards/loyaltyProgram/{loyaltyProgramId}").withRel("awardByLoyaltyProgram"));
        resource.add(new Link(self + "/awards/eligibleAwards/{loyaltyProgramId}/{points}").withRel("eligibleAwards"));
        resource.add(new Link(self + "/customers/{id}").withRel("customer"));

        return ok(resource);
    }

}
