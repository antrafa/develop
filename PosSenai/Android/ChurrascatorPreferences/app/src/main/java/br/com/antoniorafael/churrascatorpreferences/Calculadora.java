package br.com.antoniorafael.churrascatorpreferences;

import java.io.Serializable;

public final class Calculadora {

    public Integer carne;
    public Integer linguica;
    public Integer refrigerante;
    public Integer pessoas;
    public Integer consumoCarne;
    public Integer consumoLinguica;
    public Integer consumoRefrigerante;

    public Integer getCarne() {
        return carne;
    }

    public void setCarne(Integer carne) {
        this.carne = carne;
    }

    public Integer getLinguica() {
        return linguica;
    }

    public void setLinguica(Integer linguica) {
        this.linguica = linguica;
    }

    public Integer getRefrigerante() {
        return refrigerante;
    }

    public void setRefrigerante(Integer refrigerante) {
        this.refrigerante = refrigerante;
    }

    public Integer getPessoas() {
        return pessoas;
    }

    public void setPessoas(Integer pessoas) {
        this.pessoas = pessoas;
    }

    public Integer getConsumoCarne() {
        return consumoCarne;
    }

    public void setConsumoCarne(Integer consumoCarne) {
        this.consumoCarne = consumoCarne;
    }

    public Integer getConsumoLinguica() {
        return consumoLinguica;
    }

    public void setConsumoLinguica(Integer consumoLinguica) {
        this.consumoLinguica = consumoLinguica;
    }

    public Integer getConsumoRefrigerante() {
        return consumoRefrigerante;
    }

    public void setConsumoRefrigerante(Integer consumoRefrigerante) {
        this.consumoRefrigerante = consumoRefrigerante;
    }

    public void setConsumo() {
        this.consumoCarne = carne * pessoas;
        this.consumoLinguica = linguica * pessoas;
        this.consumoRefrigerante = refrigerante * pessoas;
    }

}
