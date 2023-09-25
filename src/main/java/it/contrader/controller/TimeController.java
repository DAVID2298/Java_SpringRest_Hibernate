package it.contrader.controller;

import it.contrader.converter.TimeConverter;
import it.contrader.dto.TimeDTO;
import it.contrader.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/time")
@CrossOrigin(origins = "http://localhost:4200")
public class TimeController extends AbstractController<TimeDTO> {

    @Autowired
    TimeService service;

    @Autowired
    TimeConverter converter;

    @PostMapping("/saveall")
    public List<TimeDTO> saveAll(@RequestBody List<TimeDTO> timeDTO){
        return service.saveAll(timeDTO);
    }

}