package it.contrader.dao;
import it.contrader.model.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TimeRepository extends CrudRepository<Time, Long> {


}