//package org.sid.dao;
//
//import java.util.List;
//
//
//import javax.sql.DataSource;
//
//import org.sid.entities.Reservation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Service;
//
//
//
//@Service
//public class ReservationService {
//
//	@Autowired
//	ReservationRepository reservationRepository;
//	
//	private NamedParameterJdbcTemplate jdbc;
//	
//
//	@Autowired
//	public void setDataSource(DataSource jdbc) {
//		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
//	}
//	
//	
//	public List<Reservation> findByEmail(String email)
//	{
//		return reservationRepository.findByEmail(email);
//	}
//	
//	
//	public void save(Reservation reserv) {
//		reservationRepository.save(reserv);
//
//	}
//
//	public void delete(Long id) {
//		reservationRepository.deleteById(id);
//
//	}
//
//	public boolean create(Reservation reserv) {
//
//		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(reserv);
//
//		return jdbc.update("insert into location (logement_id, email) values (:logementId, :email)", params) == 1;
//	}
//}
