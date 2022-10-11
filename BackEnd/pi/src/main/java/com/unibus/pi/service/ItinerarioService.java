package com.unibus.pi.service;

import com.unibus.pi.entities.Itinerario;
import com.unibus.pi.exception.DataIntegrityException;
import com.unibus.pi.exception.ObjectNotFoundException;
import com.unibus.pi.repository.ItinerarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class ItinerarioService {
    @Autowired
    ItinerarioRepository repository;
    @Autowired
    RotaService rotaService;

    public List<Itinerario> findAll() {
        List<Itinerario> resposta = repository.findAll();
        return resposta;
    }
    public Page<Itinerario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);
        return repository.findAll(pageRequest);
    }
    public Itinerario findById(Integer id){
        Itinerario obj = repository.findById(id).get();
        if(obj==null){
            throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ",Tipo: " + Itinerario.class.getName());
        }
        return obj;
    }
    @Transactional
    public Itinerario insert(Itinerario obj){
        try {
            // obj.setRota(rotaService.findById(obj.getRota().getId()));
            repository.save(obj).getId();
            return obj;
        } catch (Exception e) {
            return new Itinerario();
        }
    }
    @Transactional
    public Itinerario update(Itinerario obj){
        try {
            obj.setRota(rotaService.findById(obj.getRota().getId()));
            repository.save(obj).getId();
            return obj;

        } catch (Exception e) {
            return new Itinerario();
        }
    }
    public void  delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir uma Intinerario que possui vínculos com rotas!");
        }
    }
    public Itinerario findByPontoInicial(String pontoInicial){
        Itinerario obj = repository.findByPontoInicial(pontoInicial);
        if(obj==null){
            throw new ObjectNotFoundException("Objeto não encontrado! Ponto Inicial: "+ pontoInicial + ",Tipo: " + Itinerario.class.getName());
        }
        return obj;
    }
    public Itinerario findByPontoFinal(String pontoFinal){
        Itinerario obj = repository.findByPontoFinal(pontoFinal);
        if(obj==null){
            throw new ObjectNotFoundException("Objeto não encontrado! Ponto Final: "+ pontoFinal + ",Tipo: " + Itinerario.class.getName());
        }
        return obj;
    }
    public Page<Itinerario> search(
        String searchTerm,
        int page,
        int size) {
    PageRequest pageRequest = PageRequest.of(
            page,
            size,
            Sort.Direction.ASC,
            "pontoInicial","pontoFinal");

    return repository.search(
            searchTerm.toLowerCase(),
            pageRequest);
}
}
