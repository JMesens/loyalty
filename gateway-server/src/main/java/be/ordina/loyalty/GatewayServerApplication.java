package be.ordina.loyalty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.hal.CurieProvider;
import org.springframework.hateoas.hal.DefaultCurieProvider;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.mvc.BasicLinkBuilder.linkToCurrentMapping;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.ResponseEntity.ok;

@SpringBootApplication
@EnableZuulProxy
@RestController
@EnableCircuitBreaker
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }


    Map<String, UriTemplate> curries = new HashMap<>();

    @Bean
    public CurieProvider curieProvider() {
        curries.put("aw", new UriTemplate("awards/docs/{rel}.html"));
        curries.put("lp", new UriTemplate("loyaltyPrograms/docs/{rel}.html"));
        curries.put("cu", new UriTemplate("customers/docs/{rel}.html"));
        curries.put("lo", new UriTemplate("docs/{rel}.html"));
        final DefaultCurieProvider defaultCurieProvider = new DefaultCurieProvider(curries);

        return defaultCurieProvider;
    }

    @RequestMapping("/")
    public HttpEntity<ResourceSupport> index() {

        ResourceSupport resource = new ResourceSupport();
        String self = linkToCurrentMapping().toString();
        self = self.replace("://", "://admin:admin@");
        resource.add(new Link(self + "/loyaltyPrograms/loyaltyPoints/{customerId}").withRel("lp:loyaltyPoints"));
        resource.add(new Link(self + "/loyaltyPrograms/{loyaltyProgramId}").withRel("lp:loyaltyProgram"));
        resource.add(new Link(self + "/awards/").withRel("aw:awards"));
        resource.add(new Link(self + "/awards/{awardId}").withRel("aw:award"));
        resource.add(new Link(self + "/awards/loyaltyProgram/{loyaltyProgramId}").withRel("aw:awardByLoyaltyProgram"));
        resource.add(new Link(self + "/awards/eligibleAwards/{loyaltyProgramId}/{points}").withRel("aw:eligibleAwards"));
        resource.add(new Link(self + "/customers/{customerId}").withRel("customer"));

        return ok(resource);
    }

}
