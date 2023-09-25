package it.contrader.controller;

import it.contrader.converter.AppointmentConverter;
import it.contrader.dto.AppointmentDTO;
import it.contrader.model.Appointment;
import it.contrader.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController extends AbstractController<AppointmentDTO> {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentConverter converter;

    @GetMapping("/getalladmin")
    public ResponseEntity<Iterable<AppointmentDTO>> getAllByUserId(@RequestParam("userId") Long userId) {
//        return new ResponseEntity<>(appointmentService.findByUserId(userId), HttpStatus.OK);
        return new ResponseEntity<>(converter.toDTOList((List<Appointment>) appointmentService.getAllByUserId(userId)), HttpStatus.OK);
    }
}
//comee
// ee
