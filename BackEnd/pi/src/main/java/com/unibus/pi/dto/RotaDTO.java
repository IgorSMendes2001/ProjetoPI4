package com.unibus.pi.dto;

import com.unibus.pi.entities.Rota;

public class RotaDTO {
    
    private int id;
    private String nome;
    
    public RotaDTO(){
    }

    public RotaDTO(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public RotaDTO(Rota rota) {
        id = rota.getId();
        nome = rota.getNome();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
