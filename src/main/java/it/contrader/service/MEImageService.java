package it.contrader.service;

import it.contrader.Util.ImageUtil;
import it.contrader.converter.MEImageConverter;
import it.contrader.dao.MEImageRepository;
import it.contrader.dto.MEImageDTO;
import it.contrader.model.MEImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service
public class MEImageService extends AbstractService<MEImage, MEImageDTO>{

        @Autowired
        private MEImageRepository imageRepo;


        @Autowired
        MEImageConverter converter;



    @Autowired
    private MEImageRepository meImageRepository;
        public MEImage uploadImage(Long visitaId, MultipartFile file) throws IOException {


            MEImageDTO meImageDTO = new MEImageDTO();
            meImageDTO.setImageData(ImageUtil.compressImage(file.getBytes()));


            meImageDTO.setVisitaId(visitaId);
            return imageRepo.save(converter.toEntity(meImageDTO));
        }

        public void deleteImage(Long id) {

            MEImage imageData = imageRepo.findByMedicalExaminationId(id);
            byte[] imageDelete = imageData.getImageData();
            imageDelete = null;
            imageData.setImageData(null);
//       imageData.setId(null);
            imageData.setMedicalExamination(null);
            imageRepo.delete(imageData);
        }

        //    public byte[] downloadImage(Long id){
//        Optional<UserImage> imageData = imageRepo.findById(id);
//        return ImageUtil.decompressImage(imageData.get().getImageData());
//    }
        public byte[] downloadImage(Long id){
//        Optional<UserImage> imageData = imageRepo.findById(id);
            Optional<MEImage> imageData = Optional.ofNullable(imageRepo.findByMedicalExaminationId(id));
            return ImageUtil.decompressImage(imageData.get().getImageData());
        }

    public List<byte[]> downloadImages(Long id) {
        List<byte[]> imageList = new ArrayList<>();
        List<MEImage> imageDataList = imageRepo.findAllByMedicalExaminationId(id);

        for (MEImage imageData : imageDataList) {
            byte[] imageBytes = ImageUtil.decompressImage(imageData.getImageData());
            imageList.add(imageBytes);
        }

        return imageList;
    }

    public List<MEImageDTO> download(Long id){
        return converter.toDTOList((List<MEImage>) imageRepo.findAllByMedicalExaminationId(id));
    }

//    public List<byte[]> down(Long visitaId){
//        return imageRepo.findImageData(visitaId);
//    }

    public List<byte[]> downloadImagesByViewId(Long viewId) {
        // Qui dovresti implementare la logica per recuperare le immagini in base al viewId
        // Ad esempio, se stai utilizzando un repository, potresti fare qualcosa del genere:
        List<MEImage> imageDataList = imageRepo.findAllByMedicalExaminationId(viewId);

        // Dopodiché converte le immagini in byte arrays
        List<byte[]> imageBytesList = new ArrayList<>();
        for (MEImage image : imageDataList) {
            byte[] imageBytes = ImageUtil.decompressImage(image.getImageData());
            imageBytesList.add(imageBytes);
        }

        // Ritorna la lista di byte arrays
        return imageBytesList;
    }


        // private final ImageRepository imageRepository;

        public List<byte[]> downloadAndDecompressImages(Long id){
            // Qui dovresti implementare la logica per scaricare e decomprire tutte le immagini associate all'ID
            // Ad esempio:
            List<MEImage> imageList = (List<MEImage>) imageRepo.findByMedicalExaminationId(id);
            List<byte[]> imageBytesList = new ArrayList<>();
            for (MEImage image : imageList) {
                byte[] imageBytes = ImageUtil.decompressImage(image.getImageData());
                imageBytesList.add(imageBytes);
            }
            return imageBytesList;

            // Sostituisci il codice sopra con la tua implementazione effettiva.
            // Ritorna una lista vuota se le immagini non sono state trovate o se la decompressione ha fallito.
        }

    public List<String> down(Long visitaId){
        List<byte[]> image = imageRepo.findImageData(visitaId);
        List<String> img = new ArrayList<>();


        for (byte[] element: image) {
            byte[] encoded = ImageUtil.decompressImage(element);
            String ba = Base64.getEncoder().encodeToString(encoded);
            img.add(ba);
//            System.out.println(element);
//            System.out.println(encoded);
        }
//        System.out.println(image);
//        System.out.println(img);
//        byte i = img.get(2);
//        System.out.println(i);
        return img;


    }
    public String downlo(Long visitaId){
        List<byte[]> image = imageRepo.findImageData(visitaId);
        List<String> img = new ArrayList<>();

        for (byte[] element: image) {
            byte[] encoded = ImageUtil.decompressImage(element);
            String ba = Base64.getEncoder().encodeToString(encoded);
            img.add(ba);
        }


        String b = img.get(0);
        return b;
    }




}


