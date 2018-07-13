package com.tdc.react.reactintegrationapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Break {

    @SerializedName("horario")
    @Expose
    private String horario;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("descricao")
    @Expose
    private String descricao;

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
