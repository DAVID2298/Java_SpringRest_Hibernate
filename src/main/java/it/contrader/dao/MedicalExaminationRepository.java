package it.contrader.dao;

import it.contrader.model.MedicalExamination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MedicalExaminationRepository extends CrudRepository<MedicalExamination, Long> {

}