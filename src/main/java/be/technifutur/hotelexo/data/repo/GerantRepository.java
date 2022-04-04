package be.technifutur.hotelexo.data.repo;

import be.technifutur.hotelexo.models.entities.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerantRepository extends JpaRepository<Gerant, Long> {
}