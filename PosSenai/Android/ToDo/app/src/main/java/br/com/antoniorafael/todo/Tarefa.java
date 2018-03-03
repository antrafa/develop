package br.com.antoniorafael.todo;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by AntRafa on 12/10/15.
 */
public class Tarefa implements Serializable {
    private long id;
    private String titulo;
    private String descricao;
    private Long data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public String converterData(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(getData());

        int dtAno = calendar.get(Calendar.YEAR);
        int dtMes = calendar.get(Calendar.MONTH) + 1;
        int dtDia = calendar.get(Calendar.DAY_OF_MONTH);
        int dtHora = calendar.get(Calendar.HOUR_OF_DAY);
        int dtMinuto = calendar.get(Calendar.MINUTE);
        int dtSegundo = calendar.get(Calendar.SECOND);

        return dtDia+"/"+dtMes+"/"+dtAno+" Horário: "+dtHora+":"+dtMinuto;
    }

    //ARRUMANDO VALOR PARA SER MOSTRADO, COM ZERO
    private String editarValor(int valor){
        String val = "";
        if(valor < 10){
            val = "0" + String.valueOf(valor);
            return val;
        }else{
            return String.valueOf(valor);
        }
    };

    @Override
    public String toString() {
        String data = converterData();
        return data + "\nTarefa: " + getTitulo() + "\nDescrição: " + getDescricao();
    }
}
