package be.ordina.loyalty.repository;

import be.ordina.loyalty.model.LoyaltyProgram;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyProgramRepository extends JpaRepository<LoyaltyProgram,Long> {

}
