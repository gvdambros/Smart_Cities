package gvdambros.smartCities.RestAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gvdambros.smartCities.RestAPI.model.CommonUser;

@Repository
public interface CommonUserRepository extends JpaRepository<CommonUser, Long>{

}