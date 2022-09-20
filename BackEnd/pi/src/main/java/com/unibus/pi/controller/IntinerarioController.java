package com.unibus.pi.controller;

import com.unibus.pi.dto.IntinerarioDTO;
import com.unibus.pi.entities.Intinerario;
import com.unibus.pi.service.IntinerarioService;

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
@RequestMapping(value = "/intinerarios")
public class IntinerarioController {

    @Autowired
    private IntinerarioService service;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Intinerario>> findALl(){
        List<Intinerario>lista=service.findAll();

        return ResponseEntity.ok().body(lista);
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Intinerario>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page, @RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
                                               @RequestParam (value = "orderBy",defaultValue = "rotaNome") String orderBy, @RequestParam (value = "direction",defaultValue = "ASC") String direction){
        Page<Intinerario>lista=service.findPage(page,linesPerPage,orderBy,direction);

        return ResponseEntity.ok().body(lista);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Intinerario> findById(@PathVariable Integer id){
        Intinerario intinerario=service.findById(id);
        return ResponseEntity.ok().body(intinerario);
    }
    @PostMapping()
    public ResponseEntity<IntinerarioDTO> insert(@Valid @RequestBody IntinerarioDTO objDTO){
        Intinerario obj = modelMapper.map(objDTO, Intinerario.class);
        service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(objDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<IntinerarioDTO> update(@Valid @RequestBody IntinerarioDTO objDTO,@PathVariable Integer id){
        Intinerario obj = modelMapper.map(objDTO, Intinerario.class);
        service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(objDTO);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().body("Intinerario deletado com sucesso!");
    }
    @GetMapping(value = "/pesquisarPorPontoInicial")
    public ResponseEntity<Intinerario> findByPontoInicial(@RequestParam String pontoInicial){
        Intinerario intinerario=service.findByPontoInicial(pontoInicial);
        return ResponseEntity.ok().body(intinerario);
    }
    @GetMapping(value = "/pesquisarPorPontoFinal")
    public ResponseEntity<Intinerario> findByPontoFinal(@RequestParam String pontoFinal){
        Intinerario intinerario=service.findByPontoFinal(pontoFinal);
        return ResponseEntity.ok().body(intinerario);
    }
    @GetMapping("/search")
    public Page<Intinerario> search(
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
