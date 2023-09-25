package it.contrader.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder

public class MedicalExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String typology;

    @Column(unique = true)
    private String name;

    private String description;

    private double cost;

    private long code;

    @OneToMany(mappedBy = "medicalExamination", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "medicalExamination", cascade = CascadeType.ALL)
    private List<MEImage> meImages;

    @OneToMany(mappedBy = "medicalExamination", cascade = CascadeType.ALL)
    private List<Time> times;
}