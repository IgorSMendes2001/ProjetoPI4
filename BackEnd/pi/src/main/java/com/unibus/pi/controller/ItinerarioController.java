package com.unibus.pi.controller;

import com.unibus.pi.dto.ItinerarioDTO;
import com.unibus.pi.entities.Itinerario;
import com.unibus.pi.service.ItinerarioService;

import io.swagger.annotations.Api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Api(value = "API Rest intinerários")
@RestController
@RequestMapping(value = "/itinerarios")
public class ItinerarioController {

    @Autowired
    private ItinerarioService service;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Itinerario>> findAll(){
        List<Itinerario>lista=service.findAll();

        return ResponseEntity.ok().body(lista);
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Itinerario>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page, @RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
                                               @RequestParam (value = "orderBy",defaultValue = "rotaNome") String orderBy, @RequestParam (value = "direction",defaultValue = "ASC") String direction){
        Page<Itinerario>lista=service.findPage(page,linesPerPage,orderBy,direction);

        return ResponseEntity.ok().body(lista);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Itinerario> findById(@PathVariable Integer id){
        Itinerario intinerario=service.findById(id);
        return ResponseEntity.ok().body(intinerario);
    }
    @PostMapping()
    public ResponseEntity<ItinerarioDTO> insert(@Valid @RequestBody ItinerarioDTO objDTO){
        Itinerario obj = modelMapper.map(objDTO, Itinerario.class);
        service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(objDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ItinerarioDTO> update(@Valid @RequestBody ItinerarioDTO objDTO,@PathVariable Integer id){
        Itinerario obj = modelMapper.map(objDTO, Itinerario.class);
        service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(objDTO);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().body("Intinerario deletado com sucesso!");
    }
    @GetMapping(value = "/pesquisarPorPontoInicial")
    public ResponseEntity<Itinerario> findByPontoInicial(@RequestParam String pontoInicial){
        Itinerario intinerario=service.findByPontoInicial(pontoInicial);
        return ResponseEntity.ok().body(intinerario);
    }
    @GetMapping(value = "/pesquisarPorPontoFinal")
    public ResponseEntity<Itinerario> findByPontoFinal(@RequestParam String pontoFinal){
        Itinerario intinerario=service.findByPontoFinal(pontoFinal);
        return ResponseEntity.ok().body(intinerario);
    }
    @GetMapping("/search")
    public Page<Itinerario> search(
            @RequestParam("searchTerm") String searchTerm,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return service.search(searchTerm, page, size);

    }
}
