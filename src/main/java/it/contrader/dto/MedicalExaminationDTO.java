package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MedicalExaminationDTO {

    private long id;

    private String typology;

    private String name;

    private String description;

    private double cost;

    private long code;

}