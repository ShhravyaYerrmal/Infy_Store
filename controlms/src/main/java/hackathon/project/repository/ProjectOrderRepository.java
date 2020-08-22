package hackathon.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hackathon.project.Entity.ProjectOrderEntity;

public interface ProjectOrderRepository extends JpaRepository<ProjectOrderEntity,String>{

}
