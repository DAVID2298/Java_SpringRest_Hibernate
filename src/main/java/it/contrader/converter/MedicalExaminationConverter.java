package it.contrader.converter;

import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.model.MedicalExamination;
import org.springframework.stereotype.Component;

@Component
public class MedicalExaminationConverter extends AbstractConverter<MedicalExamination, MedicalExaminationDTO> {

    @Override
    public MedicalExamination toEntity(MedicalExaminationDTO medicalExaminationDTO) {
        return medicalExaminationDTO != null ? MedicalExamination.builder()
                .id(medicalExaminationDTO.getId())
                .typology(medicalExaminationDTO.getTypology())
                .name(medicalExaminationDTO.getName())
                .description(medicalExaminationDTO.getDescription())
                .cost(medicalExaminationDTO.getCost())
                .code(medicalExaminationDTO.getCode())
                .build() : null;

    }

    @Override
    public MedicalExaminationDTO toDTO(MedicalExamination medicalExamination) {
        return medicalExamination != null ? MedicalExaminationDTO.builder()
                .id(medicalExamination.getId())
                .typology(medicalExamination.getTypology())
                .name(medicalExamination.getName())
                .description(medicalExamination.getDescription())
                .cost(medicalExamination.getCost())
                .code(medicalExamination.getCode())
                .build() : null;
    }
}