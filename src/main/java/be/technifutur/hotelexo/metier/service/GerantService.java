package be.technifutur.hotelexo.metier.service;

import be.technifutur.hotelexo.models.dtos.GerantDTO;
import be.technifutur.hotelexo.models.forms.GerantForm;

import java.util.List;

public interface GerantService {

    // CREATE
    public GerantDTO insert(GerantForm form);

    // READ
    public GerantDTO getOne(Long id);
    public List<GerantDTO> getAll();

    // UPDATE
    public GerantDTO update( Long id, GerantForm form );

    // DELETE
    public GerantDTO delete ( Long id );

}
