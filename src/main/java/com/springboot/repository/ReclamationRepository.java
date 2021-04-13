package com.springboot.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.model.Reclamation;

//interface UserRepository extends JpaRepository<User, Long>
public interface ReclamationRepository extends JpaRepository<Reclamation, Long>{
	@Query("select p from Reclamation p ")
	public List<Reclamation> chercherR();
}
