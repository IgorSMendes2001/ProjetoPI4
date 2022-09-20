package com.unibus.pi.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Rota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @JsonBackReference
    @OneToMany(mappedBy = "rota",cascade = CascadeType.ALL)
    private List<Intinerario> intinerarios = new ArrayList<>();

    public Rota(){
    }

    public Rota(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Intinerario> getIntinerarios() {
        return intinerarios;
    }

    public void setIntinerarios(List<Intinerario> intinerarios) {
        this.intinerarios = intinerarios;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rota)) return false;
        Rota rota = (Rota) o;
        return id.equals(rota.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
