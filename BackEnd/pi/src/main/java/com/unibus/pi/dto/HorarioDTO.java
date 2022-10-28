package com.unibus.pi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.unibus.pi.entities.Horario;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

public class HorarioDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    @JsonFormat(pattern = "HH:mm")
    private Set<String> horarios=new HashSet<>();
    @NotNull(message = "Preenchimento do dia da Semana é obrigatório!")
    private Integer diaSemana;
    public HorarioDTO() {
    }

    public HorarioDTO(Integer id, Integer diaSemana) {
        this.id = id;
        this.diaSemana=diaSemana;
    }
    public HorarioDTO(Horario obj){
        id=obj.getId();
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

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

  
}
