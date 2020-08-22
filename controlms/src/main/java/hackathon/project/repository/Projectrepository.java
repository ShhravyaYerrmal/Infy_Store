package hackathon.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hackathon.project.Entity.ProjectEntity;
@Repository
public interface Projectrepository extends JpaRepository<ProjectEntity,String>{

	

	

}
