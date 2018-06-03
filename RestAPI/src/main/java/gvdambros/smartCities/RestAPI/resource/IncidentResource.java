package gvdambros.smartCities.RestAPI.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gvdambros.smartCities.RestAPI.builder.ObjectDataBuilder;
import gvdambros.smartCities.RestAPI.data.ObjectData;
import gvdambros.smartCities.RestAPI.model.Incident;
import gvdambros.smartCities.RestAPI.service.IncidentService;

@RestController
public class IncidentResource {

	@Autowired
	private IncidentService incidentService;

	@GetMapping("/commonUsers")
	public ObjectData<List<Incident>> getAll() {
		List<Incident> list = incidentService.findAll();
		return new ObjectDataBuilder<List<Incident>>().buildSucessful(list);
	}
	
	
}
