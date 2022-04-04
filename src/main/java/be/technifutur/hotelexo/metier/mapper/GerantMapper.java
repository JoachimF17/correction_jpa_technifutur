package be.technifutur.hotelexo.metier.mapper;

import be.technifutur.hotelexo.models.dtos.GerantDTO;
import be.technifutur.hotelexo.models.entities.Gerant;
import be.technifutur.hotelexo.models.entities.Hotel;
import be.technifutur.hotelexo.models.forms.GerantForm;
import org.springframework.stereotype.Service;

@Service
public class GerantMapper {

    public GerantDTO entityToDTO(Gerant entity){

        if( entity == null )
            return null;

        Hotel hotelEntity = entity.getGere();
        GerantDTO.HotelDTO hotel = hotelEntity == null ? null :
                new GerantDTO.HotelDTO( hotelEntity.getId(), hotelEntity.getNom() );

        return GerantDTO.builder()
                .id( entity.getId() )
                .nom( entity.getNom() )
                .prenom( entity.getPrenom() )
                .debutCarriere( entity.getDebutCarriere() )
                .hotel( hotel )
                .build();

    }

    public Gerant formToEntity(GerantForm form) {

        if( form == null )
            return null;

        return  Gerant.builder()
                .nom( form.getNom() )
                .prenom( form.getPrenom() )
                .debutCarriere( form.getDebutCarriere() )
                .build();
    }
}

