package com.unibus.pi.entities.enuns;

public enum DiaSemana {
    DIADESEMANA(1,"Dia de Semana"),
    SABADO(2,"Sábado"),
    DOMINGOEFERIADOS(3,"Domingo e Feriados");
    private int cod;
    private String descricao;
    private DiaSemana(int cod,String descricao){
        this.cod=cod;
        this.descricao=descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
    public static DiaSemana toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (DiaSemana x : DiaSemana.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido!" + cod);

    }
}

