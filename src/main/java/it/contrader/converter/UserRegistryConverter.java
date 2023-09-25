package it.contrader.converter;

import it.contrader.dto.UserDTO;
import it.contrader.dto.UserRegistryDTO;
import it.contrader.model.User;
import it.contrader.model.UserRegistry;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegistryConverter extends AbstractConverter<UserRegistry, UserRegistryDTO> {

    @Autowired
    private UserService service;

    @Autowired
    private UserConverter converter;

    @Override
    public UserRegistry toEntity(UserRegistryDTO userRegistryDTO) {
        return userRegistryDTO != null ? UserRegistry.builder()
                .id(userRegistryDTO.getId())
                .name(userRegistryDTO.getName())
                .surname(userRegistryDTO.getSurname())
                .address(userRegistryDTO.getAddress())
                .birthdate(userRegistryDTO.getBirthdate())
                .gender(userRegistryDTO.getGender())
                .nation(userRegistryDTO.getNation())
                .province(userRegistryDTO.getProvince())
                .city(userRegistryDTO.getCity())
                .user(converter.toEntity(service.read(userRegistryDTO.getUserId())))
                .build() : null;
    }

    @Override
    public UserRegistryDTO toDTO(UserRegistry userRegistry) {
        return userRegistry != null ? UserRegistryDTO.builder()
                .id(userRegistry.getId())
                .name(userRegistry.getName())
                .surname(userRegistry.getSurname())
                .address(userRegistry.getAddress())
                .birthdate(userRegistry.getBirthdate())
                .gender(userRegistry.getGender())
                .nation(userRegistry.getNation())
                .province(userRegistry.getProvince())
                .city(userRegistry.getCity())
                .userId(userRegistry.getUser().getId())
                .build() : null;
    }
}