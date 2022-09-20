package com.unibus.pi.service;

import com.unibus.pi.entities.Rota;
import com.unibus.pi.exception.DataIntegrityException;
import com.unibus.pi.repository.RotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class RotaService {
    
    @Autowired
    private RotaRepository repository;
 

    public List<Rota> findAll() {
        List<Rota> resposta = repository.findAll();
        return resposta;
    }
    public Page<Rota> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);
        return repository.findAll(pageRequest);
    }
    public Rota findById(Integer id){
        boolean existe = repository.existsById(id);
        if (existe == true) {
            Rota rota = repository.findById(id).get();
            return rota;
        }
        return new Rota();

    }
    @Transactional
    public Rota insert(Rota obj){
        try {
            repository.save(obj).getId();
            return obj;
        } catch (Exception e) {
            return new Rota();
        }
    }
    @Transactional
    public Rota update(Rota obj){
        try {
            repository.save(obj).getId();

            return obj;

        } catch (Exception e) {
            return new Rota();
        }
    }
    public void  delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir uma Rota que possui vínculos com produtos!");
        }
    }
}
