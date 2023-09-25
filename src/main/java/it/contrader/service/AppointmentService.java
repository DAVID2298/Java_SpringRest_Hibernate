package it.contrader.service;

import it.contrader.converter.AppointmentConverter;
import it.contrader.dao.AppointmentRepository;
import it.contrader.dto.AppointmentDTO;
import it.contrader.exceptions.InvalidCredentialsException;
import it.contrader.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService extends AbstractService<Appointment, AppointmentDTO>{

    @Autowired
    private AppointmentConverter converter;

    @Autowired
    private AppointmentRepository repository;

    public AppointmentDTO findByUserId(Long userId) {
        return converter.toDTO((repository.findByUserId(userId)));

    }

//    public Iterable<Appointment> findAllByIds(Iterable<Long> ids) {
//        return repository.findAllById(ids);
//

//    public List<Appointment> getAllByUserId(Long userId) {
//        List<Appointment> list = new ArrayList<>();
//        Optional<Appointment> appointment = Optional.ofNullable(repository.findByUserId(userId));
//        list.add(appointment.orElse(null));
//        return list;
//    }
        public Iterable<Appointment> getAllByUserId(Long userId) {
        return  repository.findAllByUserId(userId);

    }

}