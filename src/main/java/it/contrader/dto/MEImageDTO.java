package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MEImageDTO {

    private Long id;

    private byte[] imageData;

    private Long visitaId;
}
