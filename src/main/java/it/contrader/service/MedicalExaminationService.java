package it.contrader.service;

import it.contrader.converter.MedicalExaminationConverter;
import it.contrader.dao.MedicalExaminationRepository;
import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.model.MedicalExamination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalExaminationService extends  AbstractService<MedicalExamination, MedicalExaminationDTO> {
    @Autowired
    private MedicalExaminationConverter converter;
    @Autowired
    private MedicalExaminationRepository repository;
}
