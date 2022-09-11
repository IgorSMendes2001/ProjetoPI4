package com.unibus.pi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_rota")
public class Rota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int intinerarioId;

    public Rota(){
    }

    public Rota(int id, String nome, int intinerarioId) {
        super();
        this.id = id;
        this.nome = nome;
        this.intinerarioId = intinerarioId;
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

    public int getIntinerarioId() {
        return intinerarioId;
    }

    public void setIntinerarioId(int intinerarioId) {
        this.intinerarioId = intinerarioId;
    }
}
