package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserImageDTO {

    private Long id;

    private byte[] imageData;

    private Long userId;
}
