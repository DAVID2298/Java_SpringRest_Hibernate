package it.contrader.converter;

import it.contrader.dto.UserImageDTO;
import it.contrader.model.UserImage;
import it.contrader.model.UserRegistry;
import it.contrader.service.UserRegistryService;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserImageConverter  extends AbstractConverter<UserImage, UserImageDTO> {

    @Autowired
    UserConverter converter;

    @Autowired
    UserService service;

    @Override
    public UserImage toEntity(UserImageDTO userImageDTO) {
        return userImageDTO != null ? UserImage.builder()
                .id(userImageDTO.getId())
                .imageData(userImageDTO.getImageData())
                .user(converter.toEntity(service.read(userImageDTO.getUserId())))
                .build() : null;
    }

    @Override
    public UserImageDTO toDTO(UserImage userImage) {
        return userImage !=null ? UserImageDTO.builder()
                .id(userImage.getId())
                .imageData(userImage.getImageData())
                .userId(userImage.getUser().getId())
                .build():null;
    }
}
