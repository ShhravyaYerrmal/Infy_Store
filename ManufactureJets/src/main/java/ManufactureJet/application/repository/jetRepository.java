package ManufactureJet.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ManufactureJet.application.Entity.jetEntity;

@Repository
public interface jetRepository extends JpaRepository<jetEntity,String>{
	
	jetEntity findBymodelName(String modelName);

}
