package it.contrader.dto;


import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class HospitalRegistryDTO {

    private Long id;

    private String name;

    private String address;

    private String province;

    private String nation;

    private String city;

    private String description;

    private Long userId;

}