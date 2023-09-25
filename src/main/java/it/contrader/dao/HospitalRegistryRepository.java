package it.contrader.dao;

import it.contrader.model.HospitalRegistry;
import it.contrader.model.UserRegistry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HospitalRegistryRepository extends CrudRepository<HospitalRegistry,Long > {

    HospitalRegistry findByUserId(Long userId);


}