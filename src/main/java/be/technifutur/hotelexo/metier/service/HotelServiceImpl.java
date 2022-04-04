package be.technifutur.hotelexo.metier.service;

import be.technifutur.hotelexo.data.repo.HotelRepository;
import be.technifutur.hotelexo.exceptions.ElementNotFoundException;
import be.technifutur.hotelexo.metier.mapper.HotelMapper;
import be.technifutur.hotelexo.models.dtos.HotelDTO;
import be.technifutur.hotelexo.models.entities.Hotel;
import be.technifutur.hotelexo.models.forms.HotelForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService
{
    private final HotelRepository repository;
    private final HotelMapper mapper;

    public HotelServiceImpl(HotelRepository repository, HotelMapper mapper)
    {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public HotelDTO insert(HotelForm form)
    {
        return mapper.entityToDTO(repository.save(mapper.formToEntity(form)));
    }

    @Override
    public HotelDTO getOne(Long id)
    {
        return repository.findById(id)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(id, HotelDTO.class));
    }

    @Override
    public List<HotelDTO> getAll()
    {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public HotelDTO update(Long id, HotelForm form)
    {
        Hotel entity = repository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(id, HotelDTO.class));

        entity.setAdresse(form.getAdresse());
        entity.setNom(form.getNom());
        entity.setNbrEtoile(form.getNbEtoiles());

        entity = repository.save(entity);

        return mapper.entityToDTO(entity);
    }

    @Override
    public HotelDTO delete(Long id)
    {
        HotelDTO hotelDTO = getOne(id);
        repository.deleteById(hotelDTO.getId());
        return hotelDTO;
    }
}
