package gvdambros.smartCities.RestAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gvdambros.smartCities.RestAPI.exception.AppException;
import gvdambros.smartCities.RestAPI.model.CommonUser;
import gvdambros.smartCities.RestAPI.repository.CommonUserRepository;

@Service
public class CommonUserService {

	@Autowired
	private CommonUserRepository commonUserRepository;

	public List<CommonUser> findAll() {
		return commonUserRepository.findAll();
	}

	public CommonUser get(long id)  throws AppException {
		Optional<CommonUser> commonUser = commonUserRepository.findById(id);

		if (!commonUser.isPresent())
			throw new AppException("Bad Request");

		return commonUser.get();
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

	public CommonUser put(CommonUser commonUser, long id) throws AppException {

		Optional<CommonUser> commonUserOptional = commonUserRepository.findById(id);

		if (!commonUserOptional.isPresent()) {
			throw new AppException("Bad Request");
		}

		commonUser.setId(id);

		try{
			return commonUserRepository.save(commonUser);
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
