package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AppointmentDTO {

    private Long id;

    private String date;

    private String hour;

    private Double cost;

    private Long userId;

    private Long visitaId;
}
