package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.model.Logement;

public interface LogementRepository extends JpaRepository<Logement, Long> {
	@Query("select p from Logement p where p.intitule like :x")
	public List<Logement> chercher(@Param("x")String mc);
}
