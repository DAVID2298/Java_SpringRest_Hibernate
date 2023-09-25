package it.contrader.converter;

import it.contrader.dto.TimeDTO;
import it.contrader.model.Time;
import it.contrader.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimeConverter extends AbstractConverter<Time, TimeDTO>{

    @Autowired
    private MedicalExaminationConverter medicalExaminationConverter;

    @Autowired
    private MedicalExaminationService medicalExaminationService;
    @Override
    public Time toEntity(TimeDTO timeDTO) {
        return timeDTO != null ? Time.builder()
                .id(timeDTO.getId())
                .hour(timeDTO.getHour())
                .medicalExamination(medicalExaminationConverter.toEntity(medicalExaminationService.read(timeDTO.getVisitaId())))
                .build() : null;
    }

    @Override
    public TimeDTO toDTO(Time time) {
        return time != null ? TimeDTO.builder()
                .id(time.getId())
                .hour(time.getHour())
                .visitaId(time.getMedicalExamination().getId())
                .build() : null;
    }
}