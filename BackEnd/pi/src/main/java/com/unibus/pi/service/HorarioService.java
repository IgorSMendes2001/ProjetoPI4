package com.unibus.pi.service;

import com.unibus.pi.entities.Horario;
import com.unibus.pi.exception.DataIntegrityException;
import com.unibus.pi.exception.ObjectNotFoundException;
import com.unibus.pi.repository.HorarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class HorarioService {
    @Autowired
    HorarioRepository repository;
    @Autowired
    ItinerarioService itinerarioService;


    public List<Horario> findAll() {
        List<Horario> resposta = repository.findAll(); 
        return resposta;
    }
    public Page<Horario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);
        return repository.findAll(pageRequest);
    }
    public Horario findById(Integer id){
        boolean existe = repository.existsById(id);
		if (existe == true) {
			Horario horario = repository.findById(id).get();
			return horario;
		}
		return new Horario();

    }
    @Transactional
    public Horario insert(Horario obj){
        // try {
        //     obj.setIntinerarios(intinerarioService.findById(obj.getIntinerario().getId()));
            repository.save(obj).getId();
            return obj;
        // } catch (Exception e) {
        //     return new Horario();
        // }
    }
    @Transactional
    public Horario update(Horario obj){
        // try {
            // obj.setIntinerarios(intinerarioService.findById(obj.getIntinerario().getId()));
            repository.save(obj).getId();
            return obj;

        // } catch (Exception e) {
        //     return new Horario();
        // }
    }
    public void  delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir uma Horario que possui vínculos com produtos!");
        }
    }
    public Horario findByDiaSemana(Integer diaSemana){
        Horario obj = repository.getHorarioByDiaSemana(diaSemana);
        if(obj==null){
            throw new ObjectNotFoundException("Objeto não encontrado! Dia da semana: "+ diaSemana + ",Tipo: " + Horario.class.getName());
        }
        return obj;
    }
    public Page<Horario> search(
        String searchTerm,
        int page,
        int size) {
    PageRequest pageRequest = PageRequest.of(
            page,
            size,
            Sort.Direction.ASC,
            "horarios");

    return repository.search(
            searchTerm.toLowerCase(),
            pageRequest);
}
}
