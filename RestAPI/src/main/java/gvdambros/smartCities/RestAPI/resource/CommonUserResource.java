package gvdambros.smartCities.RestAPI.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gvdambros.smartCities.RestAPI.builder.ObjectDataBuilder;
import gvdambros.smartCities.RestAPI.data.ObjectData;
import gvdambros.smartCities.RestAPI.model.CommonUser;
import gvdambros.smartCities.RestAPI.service.CommonUserService;

@RestController
public class CommonUserResource {

	@Autowired
	private CommonUserService commonUserService;

	@GetMapping("/commonUsers")
	public ObjectData<List<CommonUser>> getAll() {
		List<CommonUser> list = commonUserService.findAll();
		return new ObjectDataBuilder<List<CommonUser>>().buildSucessful(list);
	}

	@GetMapping("/commonUsers/{id}")
	public ObjectData<?> get(@PathVariable Long id) {
		try {
			CommonUser commonUser = commonUserService.get(id);
			return new ObjectDataBuilder<CommonUser>().buildSucessful(commonUser);
		} catch(Exception e) {
			return new ObjectDataBuilder<>().buildError(e);
		}
	}

	@DeleteMapping("/commonUsers/{id}")
	public void delete(@PathVariable long id) {
		commonUserService.delete(id);
	}

	@PostMapping("/commonUsers")
	public ObjectData<?> post(@RequestBody CommonUser commonUser) {
		try {
			CommonUser commonUserCreated = commonUserService.post(commonUser);
			return new ObjectDataBuilder<CommonUser>().buildSucessful(commonUserCreated);
		} catch(Exception e) {
			return new ObjectDataBuilder<>().buildError(e);
		}
	}

	@PutMapping("/commonUsers/{id}")
	public ObjectData<?> put(@RequestBody CommonUser commonUser, @PathVariable long id) {
		try{
			CommonUser commonUserUpdated = commonUserService.put(commonUser, id);
			return new ObjectDataBuilder<CommonUser>().buildSucessful(commonUserUpdated);
		} catch(Exception e) {
			return new ObjectDataBuilder<>().buildError(e);
		}
	}
}
