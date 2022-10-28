package com.unibus.pi.entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Itinerario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String pontoInicial;
    private  String percurso;
    private  String pontoFinal;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;

    public Itinerario(){
    }

    public Itinerario(Integer id, String pontoInicial,String percurso, String pontoFinal, Rota rota,Horario horario) {
        this.id = id;
        this.pontoInicial = pontoInicial;
        this.percurso = percurso;
        this.pontoFinal = pontoFinal;
        this.rota = rota;
        this.horario=horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPontoInicial() {
        return pontoInicial;
    }

    public void setPontoInicial(String pontoInicial) {
        this.pontoInicial = pontoInicial;
    }

    public String getPercurso() {
        return percurso;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }


    public String getPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(String pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Itinerario)) return false;
        Itinerario that = (Itinerario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
