package gvdambros.smartCities.RestAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gvdambros.smartCities.RestAPI.exception.AppException;
import gvdambros.smartCities.RestAPI.model.Incident;
import gvdambros.smartCities.RestAPI.repository.IncidentRepository;

@Service
public class IncidentService {

	@Autowired
	private IncidentRepository incidentRepository;

	public List<Incident> findAll() {
		return incidentRepository.findAll();
	}

	public Incident get(long id)  throws AppException {
		Optional<Incident> incident = incidentRepository.findById(id);

		if (!incident.isPresent())
			throw new AppException("Bad Request");

		return incident.get();
	}

	public void delete(long id) {
		incidentRepository.deleteById(id);
	}

	public Incident post(Incident incident) throws AppException {
		try{
			return incidentRepository.save(incident);
		} catch(Exception e) {
			throw new AppException("Bad Request");
		} 
	}

	public Incident put(Incident incident, long id) throws AppException {

		Optional<Incident> incidentOptional = incidentRepository.findById(id);

		if (!incidentOptional.isPresent()) {
			throw new AppException("Bad Request");
		}

		incident.setId(id);

		try{
			return incidentRepository.save(incident);
		} catch(Exception e) {
			throw new AppException("Bad Request");
		} 

	}

	public List<Incident> getByUserId(Long userId) throws AppException {
		try{
			List<Incident> incidents = incidentRepository.findByUserId(userId);
			return incidents;
		} catch(Exception e) {
			throw new AppException("Bad Request");
		} 
	}
}
