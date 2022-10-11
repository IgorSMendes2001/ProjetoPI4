package com.unibus.pi.controller;

import com.unibus.pi.dto.HorarioDTO;
import com.unibus.pi.entities.Horario;
import com.unibus.pi.service.HorarioService;

import io.swagger.annotations.Api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
    @Api(value = "API Rest Horário")
    @RestController
    @RequestMapping(value = "/horarios")
    public class HorarioController {

        @Autowired
        private HorarioService service;
        @Autowired
        private ModelMapper modelMapper;

        @GetMapping
        public ResponseEntity<List<Horario>> findAll(){
            List<Horario>lista=service.findAll();

            return ResponseEntity.ok().body(lista);
        }
        @GetMapping("/page")
        public ResponseEntity<Page<Horario>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page, @RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
                                                      @RequestParam (value = "orderBy",defaultValue = "diaSemana") String orderBy, @RequestParam (value = "direction",defaultValue = "ASC") String direction){
            Page<Horario>lista=service.findPage(page,linesPerPage,orderBy,direction);

            return ResponseEntity.ok().body(lista);
        }
        @GetMapping(value = "/{id}")
        public ResponseEntity<Horario> findById(@PathVariable Integer id){
            Horario horario=service.findById(id);
            if (horario.getId() == 0||id==null) {
                return ResponseEntity.notFound().build();
            }
    
            return ResponseEntity.ok().body(horario);
        }
        @PostMapping()
        public ResponseEntity<HorarioDTO> insert(@Valid @RequestBody HorarioDTO objDTO){
            Horario obj = modelMapper.map(objDTO, Horario.class);
            service.insert(obj);
            return ResponseEntity.status(HttpStatus.CREATED).body(objDTO);
        }
        @PutMapping(value = "/{id}")
        public ResponseEntity<HorarioDTO> update(@Valid @RequestBody HorarioDTO objDTO,@PathVariable Integer id){
            Horario obj = modelMapper.map(objDTO, Horario.class);
            service.update(obj);
            return ResponseEntity.status(HttpStatus.CREATED).body(objDTO);
        }
        @DeleteMapping(value = "/{id}")
        public ResponseEntity<String> delete(@PathVariable Integer id){
            service.delete(id);
            return ResponseEntity.ok().body("Horario deletado com sucesso!");
        }
        @GetMapping(value = "/search/{diaSemana}")
        public ResponseEntity<Horario> findByDiaSemana(@PathVariable Integer diaSemana){
            Horario horario=service.findByDiaSemana(diaSemana);
            return ResponseEntity.ok().body(horario);
        }
        @GetMapping("/search")
        public Page<Horario> search(
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
