package gvdambros.smartCities.RestAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gvdambros.smartCities.RestAPI.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
	
	List<Incident> findByUserId(Long userId);
	
}