package be.technifutur.hotelexo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
@Builder
public class HotelDTO
{
    private Long id;
    private byte nbEtoiles;
    private String nom;
    private String adresse;
    private GerantDTO gerant;
    private List<ChambreDTO> chambres;

    @Data
    @AllArgsConstructor
    public static class GerantDTO
    {
        private Long id;
        private String nom;
        private String prenom;
    }

    @Data
    @AllArgsConstructor
    public static class ChambreDTO
    {
        private int num;
        private boolean aTele;
        private boolean aCuisine;
        private boolean aMiniBar;
        private float prix;
    }
}
