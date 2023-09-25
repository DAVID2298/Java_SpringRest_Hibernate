package it.contrader.service;

import it.contrader.converter.TimeConverter;
import it.contrader.dao.TimeRepository;
import it.contrader.dto.TimeDTO;
import it.contrader.model.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService extends AbstractService<Time, TimeDTO>{

    @Autowired
    TimeRepository repository;

    @Autowired
    TimeConverter converter;

    public List<TimeDTO> saveAll(List<TimeDTO> time){
        return converter.toDTOList((List<Time>) repository.saveAll(converter.toEntityList(time)));
    }
}