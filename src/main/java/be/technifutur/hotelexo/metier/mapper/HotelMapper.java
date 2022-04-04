package be.technifutur.hotelexo.metier.mapper;

import be.technifutur.hotelexo.models.dtos.HotelDTO;
import be.technifutur.hotelexo.models.entities.Chambre;
import be.technifutur.hotelexo.models.entities.Gerant;
import be.technifutur.hotelexo.models.entities.Hotel;
import be.technifutur.hotelexo.models.forms.HotelForm;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class HotelMapper
{
    public HotelDTO entityToDTO(Hotel entity){

        if( entity == null )
            return null;

        Gerant gerantEntity = entity.getGerant();
        List<Chambre> chambresEntity = entity.getChambres();
        HotelDTO.GerantDTO gerant = gerantEntity == null ? null :
                new HotelDTO.GerantDTO( gerantEntity.getId(), gerantEntity.getNom(), gerantEntity.getPrenom() );
        List<HotelDTO.ChambreDTO> chambres = chambresEntity == null ? null :
                chambresEntity.stream()
                        .map(c -> new HotelDTO.ChambreDTO(c.getNumChambre(), c.isATele(), c.isACuisine(), c.isAMiniBar(), c.getPrix()))
                        .toList();

        return HotelDTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .adresse(entity.getAdresse())
                .nbEtoiles(entity.getNbrEtoile())
                .gerant(gerant)
                .build();

    }

    public Hotel formToEntity(HotelForm form) {

        if( form == null )
            return null;

        return  Hotel.builder()
                .nom( form.getNom() )
                .adresse(form.getAdresse())
                .nbrEtoile(form.getNbEtoiles())
                .build();
    }
}
