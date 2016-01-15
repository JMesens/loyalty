package be.ordina.award.repository;

import be.ordina.award.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Award,Long> {

}
