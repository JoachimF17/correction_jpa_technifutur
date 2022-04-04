package be.technifutur.hotelexo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class GerantDTO {

    private Long id;
    private String nom;
    private String prenom;
    private LocalDate debutCarriere;
    private HotelDTO hotel;

    @Data
    @AllArgsConstructor
    public static class HotelDTO{
        private Long id;
        private String nom;
    }

}
