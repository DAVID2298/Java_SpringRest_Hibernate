package it.contrader.controller;

import it.contrader.dao.MEImageRepository;
import it.contrader.dto.MEImageDTO;
import it.contrader.model.MEImage;
import it.contrader.service.MEImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/meimage")
@CrossOrigin(origins = "http://localhost:4200")
public class MEImageController extends AbstractController<MEImageDTO>{

        @Autowired
        private MEImageService meImageService;

        @Autowired
        private MEImageRepository repository;

        @ResponseStatus(value = HttpStatus.OK)
        @PostMapping("/upload")
        public void uploadImage(@RequestParam("visitaId") Long visitaId,@RequestParam("meImage") MultipartFile file) throws IOException {

            meImageService.uploadImage(visitaId,file);
        }

//        @GetMapping("/download/{id}")
//        public ResponseEntity<List<byte[]>> downloadImage(@PathVariable Long id) {
//            List<byte[]> image = meImageService.downloadImages(id);
//            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
//        }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable Long id) {
        byte[] image = meImageService.downloadImage(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }



        @DeleteMapping("/deleteImage/{id}")
        public void deleteImage(@PathVariable Long id){
            MEImage meImage = repository.findByMedicalExaminationId(id);
            meImageService.deleteImage(id);
            if(meImage.getImageData() == null){
                meImageService.delete(meImage.getId());
            }
//        userImageService.delete(id);
        }

//    @GetMapping("/download/all")
//    public ResponseEntity<List<MultipartFile>> downloadAllImages() {
//        List<MultipartFile> images = meImageService.downloadAllImages();
//        return new ResponseEntity<>(images, HttpStatus.OK);
//    }

//    @GetMapping("/all")
//    public ResponseEntity<List<MeImage>> getAllMeImages() {
//        List<MeImage> images = meImageService.getAllMeImages();
//        return new ResponseEntity<>(images, HttpStatus.OK);
//    }
@GetMapping("/downloadByViewId/{viewId}")
public ResponseEntity<List<byte[]>> downloadImagesByViewId(@PathVariable long viewId) {
    List<byte[]> images = meImageService.downloadImagesByViewId(viewId);

    if (images.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    return ResponseEntity.status(HttpStatus.OK)
            .contentType(MediaType.valueOf("image/png"))
            .body(images);
}

    @GetMapping("/scarica")
    public ResponseEntity<List<String>> scarica(@RequestParam("visitaId") Long visitaId) {
        List<String> images = meImageService.down(visitaId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/downloads/{id}")
    public ResponseEntity<List<byte[]>> downloadImages(@PathVariable Long id) {
        List<byte[]> imageBytesList = meImageService.downloadAndDecompressImages(id);

        if (!imageBytesList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf("image/png"))
                    .body(imageBytesList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/scaricaz")
    public ResponseEntity<String> scaricaz(@RequestParam("visitaId")Long visitaId){
        String images = meImageService.downlo(visitaId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }



}

