package it.contrader.converter;

import it.contrader.dto.MEImageDTO;
import it.contrader.dto.UserImageDTO;
import it.contrader.model.MEImage;
import it.contrader.model.UserImage;
import it.contrader.service.MedicalExaminationService;
import it.contrader.service.UserRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MEImageConverter extends AbstractConverter<MEImage, MEImageDTO>{
        @Autowired
        MedicalExaminationConverter converter;

        @Autowired
        MedicalExaminationService service;

        @Override
        public MEImage toEntity(MEImageDTO meImageDTO) {
            return meImageDTO != null ? MEImage.builder()
                    .id(meImageDTO.getId())
                    .imageData(meImageDTO.getImageData())
                    .medicalExamination(converter.toEntity(service.read(meImageDTO.getVisitaId())))
                    .build() : null;
        }

        @Override
        public MEImageDTO toDTO(MEImage meImage) {
            return meImage !=null ? MEImageDTO.builder()
                    .id(meImage.getId())
                    .imageData(meImage.getImageData())
                    .visitaId(meImage.getMedicalExamination().getId())
                    .build():null;
        }

}
