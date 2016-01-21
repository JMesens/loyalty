package be.ordina.loyalty;

import be.ordina.loyalty.model.LoyaltyPoints;
import be.ordina.loyalty.model.LoyaltyProgram;
import be.ordina.loyalty.repository.LoyaltyPointsRepository;
import be.ordina.loyalty.repository.LoyaltyProgramRepository;
import be.ordina.loyalty.resources.LoyaltyProgramResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import sun.tools.jar.CommandLine;

@SpringBootApplication
@EnableEurekaClient
public class LoyaltyProgramApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LoyaltyProgramApplication.class, args);
    }

    @Autowired
    LoyaltyProgramRepository loyaltyProgramRepository;

    @Autowired
    LoyaltyPointsRepository loyaltyPointsRepository;

    @Override
    public void run(String... strings) throws Exception {

        LoyaltyProgram gold = new LoyaltyProgram("GOLD");
        loyaltyProgramRepository.save(gold);
        LoyaltyProgram bronze = new LoyaltyProgram("BRONZE");
        loyaltyProgramRepository.save(bronze);

        loyaltyPointsRepository.save(new LoyaltyPoints(1L, gold, 200));
        loyaltyPointsRepository.save(new LoyaltyPoints(2L, gold, 500));
        loyaltyPointsRepository.save(new LoyaltyPoints(3L, bronze, 300));


    }
}
