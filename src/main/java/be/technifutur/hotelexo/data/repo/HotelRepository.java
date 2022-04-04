package be.technifutur.hotelexo.data.repo;

import be.technifutur.hotelexo.models.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}