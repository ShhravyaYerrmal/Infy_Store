package com.airbus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airbus.entity.AirbusOrderEntity;

public interface ProjectOrderRepository extends JpaRepository<AirbusOrderEntity,String>{

}
