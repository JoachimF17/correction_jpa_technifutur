package be.technifutur.hotelexo.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "chambre")
public class Chambre {
    @Id
    @Column(name = "num_chambre", nullable = false)
    private int numChambre;

    @Column(nullable = false)
    private boolean aTele;

    @Column(nullable = false)
    private boolean aCuisine;

    @Column(name = "a_minibar", nullable = false)
    private boolean aMiniBar;

    @Column(nullable = false, precision = 2)
    private float prix;

    @ManyToMany
    @JoinTable(
            name = "visite",
            joinColumns = @JoinColumn(name = "chambre_id"),
            inverseJoinColumns = @JoinColumn(name = "visiteur_id"),
            uniqueConstraints = @UniqueConstraint(
                    name = "UNIK_visiteur_chambre",
                    columnNames = { "chambre_id", "visiteur_id" }
            )
    )
    private List<Client> clients = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private Hotel hotel;

}