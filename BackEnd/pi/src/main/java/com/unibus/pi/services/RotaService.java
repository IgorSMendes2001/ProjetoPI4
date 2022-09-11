package com.unibus.pi.services;

import com.unibus.pi.dto.RotaDTO;
import com.unibus.pi.entities.Rota;
import com.unibus.pi.repositories.RotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RotaService {
    
    @Autowired
    private RotaRepository repository;
    
    @Transactional(readOnly = true)
    public RotaDTO findById(int id){
        Rota entity = repository.findById(id).get();
        RotaDTO dto = new RotaDTO(entity);
        return dto;
    }
    
}
