package com.tdc.react.reactintegrationapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Talk {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("ordem")
    @Expose
    private Integer ordem;
    @SerializedName("titulo")
    @Expose
    private String titulo;
    @SerializedName("descricao")
    @Expose
    private String descricao;
    @SerializedName("tipo")
    @Expose
    private Integer tipo;
    @SerializedName("horario")
    @Expose
    private String horario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

}

