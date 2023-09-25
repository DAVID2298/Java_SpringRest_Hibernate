package it.contrader.controller;

import it.contrader.converter.HospitalRegistryConverter;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.service.HospitalRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hospitalregistry")
@CrossOrigin(origins = "http://localhost:4200")

public class HospitalRegistryController extends AbstractController<HospitalRegistryDTO> {

    @Autowired
    private HospitalRegistryService service;

    @Autowired
    private HospitalRegistryConverter converter;


    @GetMapping("/readUser")
    public ResponseEntity<HospitalRegistryDTO> read(@RequestParam("userId") Long id) {
        HospitalRegistryDTO hospitalRegistryDTO = service.findByIdUser(id);
//        return hospitalRegistryDTO;
        return new ResponseEntity<>(hospitalRegistryDTO, HttpStatus.OK);

    }
}
