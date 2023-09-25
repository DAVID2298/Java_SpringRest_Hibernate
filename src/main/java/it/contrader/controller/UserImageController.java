package it.contrader.controller;


import it.contrader.dao.UserImageRepository;
import it.contrader.dto.UserImageDTO;
import it.contrader.model.UserImage;
import it.contrader.service.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/userimage")
@CrossOrigin(origins = "http://localhost:4200")
public class UserImageController extends AbstractController<UserImageDTO>{

    @Autowired
    private UserImageService userImageService;

    @Autowired
    private UserImageRepository repository;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("userId") Long userId,@RequestParam("userImage") MultipartFile file) throws IOException {

        userImageService.uploadImage(userId,file);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long id) {
        byte[] image = userImageService.downloadImage(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

    @DeleteMapping("/deleteImage/{id}")
    public void deleteImage(@PathVariable Long id){
        UserImage userImage = repository.findByUserId(id);
        userImageService.deleteImage(id);
        if(userImage.getImageData() == null){
            userImageService.delete(userImage.getId());
        }
//        userImageService.delete(id);
    }

}
