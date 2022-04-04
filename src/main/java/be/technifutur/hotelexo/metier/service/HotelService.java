package be.technifutur.hotelexo.metier.service;

import be.technifutur.hotelexo.models.dtos.HotelDTO;
import be.technifutur.hotelexo.models.forms.HotelForm;

import java.util.List;

public interface HotelService
{
    // CREATE
    HotelDTO insert(HotelForm form);

    // READ
    HotelDTO getOne(Long id);
    List<HotelDTO> getAll();

    // UPDATE
    HotelDTO update( Long id, HotelForm form );

    // DELETE
    HotelDTO delete ( Long id );
}
