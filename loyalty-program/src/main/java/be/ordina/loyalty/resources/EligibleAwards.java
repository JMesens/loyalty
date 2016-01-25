package be.ordina.loyalty.resources;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("award")
public interface EligibleAwards {
    @RequestMapping(method = RequestMethod.GET, value = "/eligibleAwards/{loyaltyProgramId}/{points}")
    AwardsResource getEligibleAwards(@RequestParam("loyaltyProgramId") Long loyaltyProgramId, @RequestParam("points") Integer points);
}