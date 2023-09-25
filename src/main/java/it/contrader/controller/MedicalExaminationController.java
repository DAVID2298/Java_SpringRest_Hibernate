package it.contrader.controller;

import it.contrader.dto.MedicalExaminationDTO;
import it.contrader.model.MedicalExamination;
import it.contrader.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicalExamination")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationController extends AbstractController<MedicalExaminationDTO> {

    @Autowired
    MedicalExaminationService service;
}
