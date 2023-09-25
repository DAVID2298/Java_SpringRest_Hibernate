package it.contrader.dao;

import it.contrader.model.UserImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserImageRepository extends CrudRepository<UserImage,Long> {

    UserImage findByUserId(Long userId);

}
