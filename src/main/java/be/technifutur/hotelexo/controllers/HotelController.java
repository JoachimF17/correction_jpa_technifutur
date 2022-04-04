package be.technifutur.hotelexo.controllers;

import be.technifutur.hotelexo.metier.mapper.GerantMapper;
import be.technifutur.hotelexo.metier.service.GerantServiceImpl;
import be.technifutur.hotelexo.metier.service.HotelService;
import be.technifutur.hotelexo.models.dtos.HotelDTO;
import be.technifutur.hotelexo.models.forms.GerantForm;
import be.technifutur.hotelexo.models.forms.HotelForm;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController
{
    private final HotelService service;

    public HotelController(HotelService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<HotelDTO> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getOne(id));
    }

    @PostMapping({"","/add"})
    public ResponseEntity<?> insert(@RequestBody HotelForm form)
    {
        return ResponseEntity.ok(service.insert(form));
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody HotelForm form)
    {
        return ResponseEntity.ok(service.update(id, form));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/etoiles/{nbEtoiles}")
    public ResponseEntity<?> getAllByNbEtoiles(@PathVariable byte nbEtoiles)
    {
        return ResponseEntity.ok(
                service.getAll()
                        .stream()
                        .filter((h) -> h.getNbEtoiles() >= nbEtoiles)
                        .toList()
        );
    }

    /*@GetMapping("/{id}/gerant/modifier")
    public ResponseEntity<?> updateGerant(@PathVariable Long id, @RequestBody GerantForm form)
    {
        GerantController gerantController;
        return ResponseEntity.ok(gerantController.update(service.getOne(id).getGerant().getId(), form));
    }*/
}
