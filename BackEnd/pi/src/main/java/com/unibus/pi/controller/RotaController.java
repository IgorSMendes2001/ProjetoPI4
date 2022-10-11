package com.unibus.pi.controller;

import com.unibus.pi.dto.RotaDTO;
import com.unibus.pi.entities.Rota;
import com.unibus.pi.service.RotaService;

import io.swagger.annotations.Api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@Api(value = "API REST Rotas")
@RestController
@RequestMapping(value = "/rotas")
public class RotaController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RotaService service;

    @GetMapping
    public ResponseEntity<List<Rota>> findAll(){
        List<Rota>lista=service.findAll();

        return ResponseEntity.ok().body(lista);
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Rota>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page, @RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
                                                  @RequestParam (value = "orderBy",defaultValue = "nome") String orderBy, @RequestParam (value = "direction",defaultValue = "ASC") String direction){
        Page<Rota>lista=service.findPage(page,linesPerPage,orderBy,direction);

        return ResponseEntity.ok().body(lista);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Rota> findById(@PathVariable Integer id){
        Rota rota=service.findById(id);
        return ResponseEntity.ok().body(rota);
    }
    @GetMapping(value = "/procurarPorNome")
    public ResponseEntity<Rota> findByNome(@RequestParam String nome){
        Rota rota=service.findByNome(nome);
        return ResponseEntity.ok().body(rota);
    }
    @PostMapping()
    public ResponseEntity<RotaDTO> insert(@Valid @RequestBody RotaDTO objDto){
        Rota rota = modelMapper.map(objDto, Rota.class);
        Integer id = service.insert(rota).getId();
        objDto.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(objDto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Rota> update(@Valid @RequestBody RotaDTO objDto ,@PathVariable Integer id){
        Rota rota=modelMapper.map(objDto, Rota.class);
                 service.update(rota).getId();
        return ResponseEntity.status(HttpStatus.CREATED).body(rota);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().body("Rota deletada com sucesso");
    }
    @GetMapping("/search")
    public Page<Rota> search(
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
