package it.contrader.dao;

import it.contrader.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    Appointment findByUserId(Long userId);

    Iterable<Appointment> findAllByUserId(Long userId);
}