package be.technifutur.hotelexo.controllers;

import be.technifutur.hotelexo.exceptions.ElementNotFoundException;
import be.technifutur.hotelexo.metier.service.GerantService;
import be.technifutur.hotelexo.models.dtos.ErrorDTO;
import be.technifutur.hotelexo.models.dtos.GerantDTO;
import be.technifutur.hotelexo.models.forms.GerantForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerant")
public class GerantController {

    private final GerantService service;

    public GerantController(GerantService service) {
        this.service = service;
    }

    @GetMapping
    public List<GerantDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(name = "id") Long id )
    {
        try
        {
            return ResponseEntity.status(HttpStatus.OK)
                    .header("from-controller", "GerantController")
                    .body( service.getOne(id) );
        }
        catch (ElementNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("header-key", "value1", "value2")
                    .body( new ErrorDTO(e.getMessage(),404,"/gerant/"+id) );
        }
    }

    @PostMapping({"","/add"})
    public ResponseEntity<?> insert(@RequestBody  GerantForm form)
    {
        try {
            return ResponseEntity.ok(service.insert(form));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity
                    .badRequest()
                    .body(new ErrorDTO(e.getMessage(),"/gerant/add"));
        }
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GerantForm form)
    {
        try
        {
            return ResponseEntity.ok(service.update(id, form));
        }catch (ElementNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("header-key", "value1", "value2")
                    .body(new ErrorDTO(e.getMessage(),404,"/gerant/"+id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        try
        {
            return ResponseEntity.ok(service.delete(id));
        }catch (ElementNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("header-key", "value1", "value2")
                    .body(new ErrorDTO(e.getMessage(),404,"/gerant/"+id));
        }
    }
}
