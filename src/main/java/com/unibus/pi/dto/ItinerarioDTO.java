package com.unibus.pi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


public class ItinerarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Integer id;
    @NotEmpty(message = "Preenchimento do ponto inicial é obrigatório!")
    @Length(min = 5,max = 80,message = "O tamanho deve ser entre 5 e 80 caracteres")
    private  String pontoInicial;
    @NotEmpty(message = "Preenchimento do percurso é obrigatório!")
    @Length(min = 5,max = 80,message = "O tamanho deve ser entre 5 e 80 caracteres")
    private  String percurso;
    @NotEmpty(message = "Preenchimento do ponto final é obrigatório!")
    @Length(min = 5,max = 80,message = "O tamanho deve ser entre 5 e 80 caracteres")
    private  String pontoFinal;
    @NotNull(message = "Preenchimento do id de Horário é obrigatório!")
    private Integer horarioId;
    @NotNull(message = "Preenchimento do id de Rota é obrigatório!")
    private Integer rotaId;

    public ItinerarioDTO() {
    }

    public ItinerarioDTO(Integer id, String pontoInicial, String percurso, String pontoFinal,Integer rotaId,Integer horarioId) {
        this.id = id;
        this.pontoInicial = pontoInicial;
        this.percurso = percurso;
        this.pontoFinal = pontoFinal;
        this.rotaId=rotaId;
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

    public Integer getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Integer horarioId) {
        this.horarioId = horarioId;
    }

    public Integer getRotaId() {
        return rotaId;
    }

    public void setRotaId(Integer rotaId) {
        this.rotaId = rotaId;
    }



}
