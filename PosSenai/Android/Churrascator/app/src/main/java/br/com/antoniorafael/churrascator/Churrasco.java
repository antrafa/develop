package br.com.antoniorafael.churrascator;

import java.io.Serializable;

/**
 * Created by AntRafa on 12/09/15.
 */
public final class Churrasco implements Serializable {

    public static Integer carne;
    public static Integer linguica;
    public static Integer refrigerante;
    public static Integer pessoas;
    public static Integer consumoCarne;
    public static Integer consumoLinguica;
    public static Integer consumoRefrigerante;

    private static Churrasco INSTANCE = null;

    protected Churrasco() {
    }

    public static Churrasco getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Churrasco();
        }
        return INSTANCE;
    }

    public static Integer getCarne() {
        return carne;
    }
    public static Integer getLinguica() {
        return linguica;
    }
    public static Integer getRefrigerante() {
        return refrigerante;
    }
    public static Integer getPessoas() {
        return pessoas;
    }
    public static void setPessoas(Integer pessoas) {
        Churrasco.pessoas = pessoas;
    }
    public static void setCarne(Integer carne) {
        Churrasco.carne = carne;
    }
    public static void setLinguica(Integer linguica) { Churrasco.linguica = linguica; }
    public static void setRefrigerante(Integer refrigerante) { Churrasco.refrigerante = refrigerante; }
    public static Integer getConsumoCarne() { return consumoCarne; }
    public static Integer getConsumoLinguica() { return consumoLinguica; }
    public static Integer getConsumoRefrigerante() { return consumoRefrigerante; }

    public static void setConsumo() {
        Churrasco.consumoCarne = carne * pessoas;
        Churrasco.consumoLinguica = linguica * pessoas;
        Churrasco.consumoRefrigerante = refrigerante * pessoas;
    }

}
