package it.contrader.service;

import it.contrader.Util.ImageUtil;
import it.contrader.converter.UserImageConverter;
import it.contrader.dao.UserImageRepository;
import it.contrader.dto.UserImageDTO;
import it.contrader.model.UserImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserImageService extends AbstractService<UserImage, UserImageDTO>{

    @Autowired
    private UserImageRepository imageRepo;


    @Autowired
    UserImageConverter converter;



    public UserImage uploadImage(Long userId, MultipartFile file) throws IOException {


        UserImageDTO userImage = new UserImageDTO();
        userImage.setImageData(ImageUtil.compressImage(file.getBytes()));


        userImage.setUserId(userId);
        return imageRepo.save(converter.toEntity(userImage));
    }

    public void deleteImage(Long id) {

       UserImage imageData = imageRepo.findByUserId(id);
       byte[] imageDelete = imageData.getImageData();
       imageDelete = null;
       imageData.setImageData(null);
//       imageData.setId(null);
       imageData.setUser(null);
       imageRepo.delete(imageData);
    }

//    public byte[] downloadImage(Long id){
//        Optional<UserImage> imageData = imageRepo.findById(id);
//        return ImageUtil.decompressImage(imageData.get().getImageData());
//    }
    public byte[] downloadImage(Long id){
//        Optional<UserImage> imageData = imageRepo.findById(id);
        Optional<UserImage> imageData = Optional.ofNullable(imageRepo.findByUserId(id));
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }
}
