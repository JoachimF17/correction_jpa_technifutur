package be.technifutur.hotelexo.data.repo;

import be.technifutur.hotelexo.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}