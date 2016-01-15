package be.ordina.loyalty.repository;

import be.ordina.loyalty.model.LoyaltyPoints;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyPointsRepository extends JpaRepository<LoyaltyPoints,Long>{

    LoyaltyPoints getLoyaltyPointsByCustomerId(Long customerId);

}
