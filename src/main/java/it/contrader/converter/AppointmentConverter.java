package it.contrader.converter;

import it.contrader.dto.AppointmentDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Appointment;
import it.contrader.model.User;
import it.contrader.service.MedicalExaminationService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentConverter extends AbstractConverter<Appointment, AppointmentDTO> {

    @Autowired
    private UserService service;

    @Autowired
    private UserConverter converter;

    @Autowired
    private MedicalExaminationConverter conv;

    @Autowired
    private MedicalExaminationService ser;

    @Override
    public Appointment toEntity(AppointmentDTO appointmentDTO) {
        return appointmentDTO != null ? Appointment.builder()
                .id(appointmentDTO.getId())
                .date(appointmentDTO.getDate())
                .hour(appointmentDTO.getHour())
                .cost(appointmentDTO.getCost())
                .user(converter.toEntity(service.read(appointmentDTO.getUserId())))
                .medicalExamination(conv.toEntity(ser.read(appointmentDTO.getVisitaId())))
                .build() : null;



    }

    @Override
    public AppointmentDTO toDTO(Appointment appointment) {
        return appointment != null ? AppointmentDTO.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .hour(appointment.getHour())
                .cost(appointment.getCost())
                .userId(appointment.getUser().getId())
                .visitaId(appointment.getMedicalExamination().getId())
                .build() : null;

    }
}