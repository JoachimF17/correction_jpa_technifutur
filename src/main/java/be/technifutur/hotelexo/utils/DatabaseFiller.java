package be.technifutur.hotelexo.utils;

import be.technifutur.hotelexo.data.repo.GerantRepository;
import be.technifutur.hotelexo.data.repo.HotelRepository;
import be.technifutur.hotelexo.models.entities.Gerant;
import be.technifutur.hotelexo.models.entities.Hotel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatabaseFiller implements InitializingBean {

    private final HotelRepository repository;
    private final GerantRepository gRepo;

    public DatabaseFiller(HotelRepository repository, GerantRepository gRepo) {
        this.repository = repository;
        this.gRepo = gRepo;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Gerant g = Gerant.builder()
                .debutCarriere(LocalDate.now())
                .prenom("luc")
                .nom("dubois")
                .build();
        gRepo.save(g);

        g = Gerant.builder()
                .debutCarriere(LocalDate.now().minusDays(2))
                .prenom("marie")
                .nom("desmet")
                .build();
        g = gRepo.save(g);

        Hotel h = Hotel.builder()
                .nom("Grand Budapest")
                .adresse("0 rue null")
                .gerant(g)
                .nbrEtoile((byte)3)
                .build();

        repository.save(h);

    }
}
