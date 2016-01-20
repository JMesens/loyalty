package be.ordina.award.repository;

import be.ordina.award.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AwardRepository extends JpaRepository<Award,Long> {

    List<Award> findAwardsByLoyaltyProgramId(Long loyaltyProgramId);

    List<Award> findAwardsByLoyaltyProgramIdAndPriceLessThanEqual(Long loyaltyProgramId, Integer price);

}
