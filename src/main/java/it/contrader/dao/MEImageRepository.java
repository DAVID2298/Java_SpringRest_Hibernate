package it.contrader.dao;

import it.contrader.model.MEImage;
import it.contrader.model.UserImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface MEImageRepository extends CrudRepository<MEImage,Long> {

    MEImage findByMedicalExaminationId(Long visitaId);

    List<MEImage> findAllByMedicalExaminationId(Long visitaId);

    @Query("SELECT imageData FROM MEImage WHERE visita_id = :visitaId")
    List<byte[]> findImageData(@Param("visitaId") Long visitaId);
}
