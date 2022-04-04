package be.technifutur.hotelexo.data.repo;

import be.technifutur.hotelexo.models.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {
}