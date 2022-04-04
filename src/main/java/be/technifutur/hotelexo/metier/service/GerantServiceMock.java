package be.technifutur.hotelexo.metier.service;

import be.technifutur.hotelexo.models.dtos.GerantDTO;
import be.technifutur.hotelexo.models.forms.GerantForm;

import java.util.List;

//@Service
public class GerantServiceMock implements GerantService {
    @Override
    public GerantDTO insert(GerantForm form) {
        return null;
    }

    @Override
    public GerantDTO getOne(Long id) {
        return null;
    }

    @Override
    public List<GerantDTO> getAll() {
        return null;
    }

    @Override
    public GerantDTO update(Long id, GerantForm form) {
        return null;
    }

    @Override
    public GerantDTO delete(Long id) {
        return null;
    }
}
