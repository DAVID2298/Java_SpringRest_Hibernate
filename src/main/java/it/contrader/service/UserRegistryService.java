package it.contrader.service;

import it.contrader.Util.ImageUtil;
import it.contrader.converter.UserRegistryConverter;
import it.contrader.dao.UserRegistryRepository;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UserRegistryService extends AbstractService<UserRegistry, UserRegistryDTO>  {

    @Autowired
    UserRegistryRepository repository;

    @Autowired
    UserRegistryConverter converter;


    public UserRegistryDTO findByIdUser(Long userId){
        return converter.toDTO(repository.findByUserId(userId));
    }

    public UserRegistryDTO findByUserByName(String name){
        return converter.toDTO(repository.findUserByName(name));
    }


}
