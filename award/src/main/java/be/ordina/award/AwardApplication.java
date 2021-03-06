package be.ordina.award;

import be.ordina.award.entity.Award;
import be.ordina.award.repository.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient("award")
@EnableEurekaClient
public class AwardApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AwardApplication.class, args);
    }

    @Autowired
    AwardRepository awardRepository;

    @Override
    public void run(String... strings) throws Exception {
        awardRepository.save(new Award("Gold Award", 1L, 100));
        awardRepository.save(new Award("An Other Gold Award", 1L, 200));
        awardRepository.save(new Award("Bronze Award", 2L, 100));
        awardRepository.save(new Award("An Other Bronze Award", 2L, 200));
        awardRepository.save(new Award("A Refurbished Bronze Award", 2L, 50));
    }
}
