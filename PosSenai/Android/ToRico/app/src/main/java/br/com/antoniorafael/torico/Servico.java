package br.com.antoniorafael.torico;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;

import java.text.DecimalFormat;

public class Servico extends Service implements Runnable {

    private int horas;
    private int minutos;
    private int segundos;
    private String tempo = "";
    private int count;
    private boolean ativo;
    private SharedPreferences preferences;
    private Double salarioBruto;
    private Double horasNormais;
    private Double adicional;
    private Double ganho;
    DecimalFormat decimalFormat = new DecimalFormat( "#,###,###,##0.00" );

    //Criando um handler para agendar a chamada (executar o run deste serviço novamente)
    private Handler myHandler = new Handler();
    private Handler handlerInicial = new Handler();

    public void setHandler(Handler h){
        handlerInicial = h;
    }

    //instanciando meu LocalBinder criado como inner class para passar o onBind
    LocalBinder binder = new LocalBinder();

    public Servico() {
    }

    //preparando o contexto para as preferencias
    @Override
    public void onCreate() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void run() {

        if(ativo){

            myHandler.postAtTime(this, SystemClock.uptimeMillis() + 1000);
            contandoTempo();
            montandoTempo();
            calcularGanho();
            mostrandoDados();

            //Log.i("Teste", "Tempo: " + tempo);
            return;

        }

    }

    public void mostrandoDados(){

        if(handlerInicial != null){
            //Criando um bundle porque Message recebe um bundle. Colocando dados nele, para passar para o handler da inicial
            Bundle bundle = new Bundle();
            bundle.putString("tempo", getTempo());
            bundle.putString("valor_hora",decimalFormat.format(getValorHora()).toString());// getValorHora().toString()
            bundle.putString("ganho", decimalFormat.format(getGanho()).toString());// getGanho().toString()

            //Criando message porque o Handler recebe para mostrar na view (comunicação)
            Message m = new Message();
            m.setData(bundle);

            //Enviando para o método que foi sobreescrito na inicial
            handlerInicial.sendMessage(m);
        }

    }

    public void carregarPreferencias(){

        salarioBruto = Double.parseDouble(preferences.getString("salario_bruto","2000"));
        horasNormais = Double.parseDouble(preferences.getString("horas_normais","220"));
        adicional = Double.parseDouble(preferences.getString("adicional", "30"));

    }

    public Double getValorHora(){
        Double valorHora = salarioBruto / horasNormais + ((salarioBruto / horasNormais) * (adicional / 100));
        return valorHora;
    }

    public Double getGanho(){
        return ganho;
    }

    public Double calcularGanho(){
        ganho = ((getValorHora() / 60) / 60) * count;
        return ganho;
    }

    public void contandoTempo(){
        count++;//usado para o calculo do ganho (não pode ser segundos porque zera)
        segundos++;
        if(segundos == 60){
            minutos++;
            segundos = 0;
        }
        if(minutos == 60){
            horas++;
            minutos = 0;
        }
    }

    public void montandoTempo(){

        tempo = "";
        if(horas < 10){
            tempo += "0";
        }
        tempo += String.valueOf(horas);
        tempo += ":";
        if(minutos < 10){
            tempo += "0";
        }
        tempo += String.valueOf(minutos);
        tempo += ":";
        if(segundos < 10){
            tempo += "0";
        }
        tempo += String.valueOf(segundos);
    }

    public String getTempo() {
        return tempo;
    }

    public boolean getAtivo(){
        return ativo;
    }

    //Binder que será retornado o onBind, quando chamar o serviço
    //onBind retorna uma implementação de IBinder
    public class LocalBinder extends Binder {
        public Servico getServico(){
            return Servico.this;
        }
    }

    public void iniciar(){
        carregarPreferencias();
        if(ativo == false) {
            ativo = true;
            myHandler.post(this);
        }
    }

    public void pausar(){
        ativo = false;
    }

    public void parar(){
        ativo = false;

        //zerando
        horas = 0;
        minutos = 0;
        segundos = 0;
        count = 0;
    }
}
