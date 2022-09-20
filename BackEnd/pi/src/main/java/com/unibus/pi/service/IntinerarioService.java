package com.unibus.pi.service;

import com.unibus.pi.entities.Intinerario;
import com.unibus.pi.exception.DataIntegrityException;
import com.unibus.pi.exception.ObjectNotFoundException;
import com.unibus.pi.repository.IntinerarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class IntinerarioService {
    @Autowired
    IntinerarioRepository repository;
    @Autowired
    RotaService rotaService;

    public List<Intinerario> findAll() {
        List<Intinerario> resposta = repository.findAll();
        return resposta;
    }
    public Page<Intinerario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);
        return repository.findAll(pageRequest);
    }
    public Intinerario findById(Integer id){
        Intinerario obj = repository.findById(id).get();
        if(obj==null){
            throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id + ",Tipo: " + Intinerario.class.getName());
        }
        return obj;
    }
    @Transactional
    public Intinerario insert(Intinerario obj){
        try {
            // obj.setRota(rotaService.findById(obj.getRota().getId()));
            repository.save(obj).getId();
            return obj;
        } catch (Exception e) {
            return new Intinerario();
        }
    }
    @Transactional
    public Intinerario update(Intinerario obj){
        try {
            obj.setRota(rotaService.findById(obj.getRota().getId()));
            repository.save(obj).getId();
            return obj;

        } catch (Exception e) {
            return new Intinerario();
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
}
