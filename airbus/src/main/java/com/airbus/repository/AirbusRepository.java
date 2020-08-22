package com.airbus.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.airbus.entity.AirbusEntity;

@Repository
public interface AirbusRepository extends JpaRepository<AirbusEntity,String> {

	Optional<AirbusEntity> findBymodelName(String modelName);
	
	  	


}
