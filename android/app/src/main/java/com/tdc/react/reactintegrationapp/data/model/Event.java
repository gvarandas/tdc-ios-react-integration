package com.tdc.react.reactintegrationapp.data.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("descricao")
    @Expose
    private String descricao;
    @SerializedName("urlSite")
    @Expose
    private String urlSite;
    @SerializedName("ativo")
    @Expose
    private Boolean ativo;
    @SerializedName("posicaoNoEvento")
    @Expose
    private Integer posicaoNoEvento;
    @SerializedName("slogan")
    @Expose
    private String slogan;
    @SerializedName("descricaoDetalhada")
    @Expose
    private String descricaoDetalhada;
    @SerializedName("publicoAlvo")
    @Expose
    private String publicoAlvo;
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("publicarNoSite")
    @Expose
    private Boolean publicarNoSite;
    @SerializedName("intervalos")
    @Expose
    private List<Break> intervalos = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlSite() {
        return urlSite;
    }

    public void setUrlSite(String urlSite) {
        this.urlSite = urlSite;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getPosicaoNoEvento() {
        return posicaoNoEvento;
    }

    public void setPosicaoNoEvento(Integer posicaoNoEvento) {
        this.posicaoNoEvento = posicaoNoEvento;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public String getPublicoAlvo() {
        return publicoAlvo;
    }

    public void setPublicoAlvo(String publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Boolean getPublicarNoSite() {
        return publicarNoSite;
    }

    public void setPublicarNoSite(Boolean publicarNoSite) {
        this.publicarNoSite = publicarNoSite;
    }

    public List<Break> getIntervalos() {
        return intervalos;
    }

    public void setIntervalos(List<Break> intervalos) {
        this.intervalos = intervalos;
    }

}
