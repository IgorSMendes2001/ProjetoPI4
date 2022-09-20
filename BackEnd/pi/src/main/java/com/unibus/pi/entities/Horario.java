package com.unibus.pi.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.unibus.pi.entities.enuns.DiaSemana;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Horario implements Serializable {
    private static final long serialVersionUID=1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ElementCollection
    @CollectionTable(name = "HORARIOS")
    private Set<String> horarios=new HashSet<>();

    private Integer diaSemana;
    @JsonBackReference
    @OneToMany(mappedBy = "rota",cascade = CascadeType.ALL)
    private List<Intinerario> intinerarios = new ArrayList<>();

    public Horario(Integer id, DiaSemana diaSemana) {
        this.id = id;
        this.diaSemana=(diaSemana==null)?null:diaSemana.getCod();
    }

    public Horario(){
}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<String> getHorarios() {
        return horarios;
    }

    public void setHorarios(Set<String> horarios) {
        this.horarios = horarios;
    }

    public String getDiaSemana() {
        return DiaSemana.toEnum(diaSemana).getDescricao();
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }
    

    public List<Intinerario> getIntinerarios() {
        return intinerarios;
    }

    public void setIntinerarios(List<Intinerario> intinerarios) {
        this.intinerarios = intinerarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Horario)) return false;
        Horario horario = (Horario) o;
        return id.equals(horario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
