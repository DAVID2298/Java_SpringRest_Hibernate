package it.contrader.service;

import it.contrader.converter.HospitalRegistryConverter;
import it.contrader.dao.HospitalRegistryRepository;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.model.HospitalRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalRegistryService extends AbstractService<HospitalRegistry, HospitalRegistryDTO>{

    @Autowired
    HospitalRegistryRepository repository;

    @Autowired
    HospitalRegistryConverter converter;

    public HospitalRegistryDTO findByIdUser(Long userId){
        return converter.toDTO(repository.findByUserId(userId));
    }

}
