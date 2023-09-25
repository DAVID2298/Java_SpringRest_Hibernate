package it.contrader.controller;

import it.contrader.converter.UserRegistryConverter;
import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.service.UserRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/userregistry")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRegistryController extends  AbstractController<UserRegistryDTO>{

    @Autowired
    UserRegistryService service;

    @Autowired
    UserRegistryConverter converter;

    @GetMapping("/readUser")
    public ResponseEntity<UserRegistryDTO> read(@RequestParam("userId")Long id){
        UserRegistryDTO userRegistryDTO= service.findByIdUser(id);
        return new ResponseEntity<>(userRegistryDTO, HttpStatus.OK);
//        return userRegistryDTO;
    }

    @GetMapping("/readbyname")
    public ResponseEntity<UserRegistryDTO> findByUserByName(@RequestParam("name")String name){
        UserRegistryDTO userRegistryDTO= service.findByUserByName(name);
        return new ResponseEntity<>(userRegistryDTO,HttpStatus.OK);
    }


}
