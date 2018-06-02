package gvdambros.smartCities.RestAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import gvdambros.smartCities.RestAPI.exception.AppException;
import gvdambros.smartCities.RestAPI.model.CommonUser;
import gvdambros.smartCities.RestAPI.repository.CommonUserRepository;

@RestController
public class CommonUserService {

	@Autowired
	private CommonUserRepository commonUserRepository;

	public List<CommonUser> findAll() {
		return commonUserRepository.findAll();
	}

	public CommonUser get(long id)  throws AppException {
		Optional<CommonUser> student = commonUserRepository.findById(id);

		if (!student.isPresent())
			throw new AppException("Bad Request");

		return student.get();
	}

	public void delete(long id) {
		commonUserRepository.deleteById(id);
	}

	public CommonUser post(CommonUser commonUser) throws AppException {
		try{
			return commonUserRepository.save(commonUser);
		} catch(Exception e) {
			throw new AppException("Bad Request");
		} 
	}

	public CommonUser put(CommonUser student, long id) throws AppException {

		Optional<CommonUser> studentOptional = commonUserRepository.findById(id);

		if (!studentOptional.isPresent()) {
			throw new AppException("Bad Request");
		}

		student.setId(id);

		try{
			return commonUserRepository.save(student);
		} catch(Exception e) {
			throw new AppException("Bad Request");
		} 

	}

	public CommonUser login(String email, String password) throws AppException {
		try{
			CommonUser commonUser = commonUserRepository.findByEmail(email);
			if(!commonUser.getPassword().equals(password)) {
				throw new AppException("Wrong password");
			}
			commonUser.erasePassword();
			return commonUser;
		} catch(Exception e) {
			throw new AppException("Bad Request");
		} 

	}
}
