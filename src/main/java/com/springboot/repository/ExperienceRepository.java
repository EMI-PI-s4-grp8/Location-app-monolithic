package com.springboot.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;

import com.springboot.model.Experience;
import com.springboot.model.Logement;

public interface ExperienceRepository extends JpaRepository<Experience, Long>{
//@Query("select p from experience p ")
//public List<Experience> chercher();
	
//	@Query("select p from experience p where p.avis like :x")
//	public List<Experience> chercher(@Param("x")String mc);


}
