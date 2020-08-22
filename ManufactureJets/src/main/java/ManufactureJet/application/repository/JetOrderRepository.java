package ManufactureJet.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ManufactureJet.application.Entity.jetOrderEntity;

public interface JetOrderRepository extends JpaRepository<jetOrderEntity,Integer> {
	
}
