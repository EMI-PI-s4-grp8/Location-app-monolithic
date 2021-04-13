package com.springboot.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
//	@Query("select r from Resevation r where p.Id like :s")
//	public List<Reservation> chercher(@Param("s")String mc);
}