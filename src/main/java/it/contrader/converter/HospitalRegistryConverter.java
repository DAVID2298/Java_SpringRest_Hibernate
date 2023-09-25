package it.contrader.converter;

import it.contrader.dto.HospitalRegistryDTO;
import it.contrader.model.HospitalRegistry;
import it.contrader.model.UserRegistry;
import it.contrader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HospitalRegistryConverter extends AbstractConverter<HospitalRegistry, HospitalRegistryDTO>{

    @Autowired
    private UserService service;

    @Autowired
    private UserConverter converter;

    @Override
    public HospitalRegistry toEntity(HospitalRegistryDTO hospitalRegistryDTO) {
        return hospitalRegistryDTO != null ? HospitalRegistry.builder()
                .id(hospitalRegistryDTO.getId())
                .name(hospitalRegistryDTO.getName())
                .address(hospitalRegistryDTO.getAddress())
                .province(hospitalRegistryDTO.getProvince())
                .nation(hospitalRegistryDTO.getNation())
                .city(hospitalRegistryDTO.getCity())
                .description(hospitalRegistryDTO.getDescription())
                .user(converter.toEntity(service.read(hospitalRegistryDTO.getUserId())))
                .build() : null;
    }

    @Override
    public HospitalRegistryDTO toDTO(HospitalRegistry hospitalRegistry) {
        return hospitalRegistry != null ? HospitalRegistryDTO.builder()
                .id(hospitalRegistry.getId())
                .name(hospitalRegistry.getName())
                .address(hospitalRegistry.getAddress())
                .province(hospitalRegistry.getProvince())
                .nation(hospitalRegistry.getNation())
                .city(hospitalRegistry.getCity())
                .description(hospitalRegistry.getDescription())
                .userId(hospitalRegistry.getUser().getId())
                .build() : null;
    }
}
