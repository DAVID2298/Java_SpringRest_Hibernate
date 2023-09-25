package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistryDTO {

    private Long id;

    private String name;

    private String surname;

    private String address;

    private String birthdate;

    private String gender;

    private String nation;

    private String province;

    private String city;

    private Long userId;

}