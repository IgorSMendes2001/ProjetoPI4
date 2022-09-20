package com.unibus.pi.dto;

import java.io.Serializable;


public class IntinerarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private  Integer id;
    private  String pontoInicial;
    private  String percurso;
    private  String pontoFinal;
    private Integer horarioId;
    private Integer rotaId;

    public IntinerarioDTO() {
    }

    public IntinerarioDTO(Integer id, String pontoInicial, String percurso, String pontoFinal,Integer rotaId,Integer horarioId) {
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
