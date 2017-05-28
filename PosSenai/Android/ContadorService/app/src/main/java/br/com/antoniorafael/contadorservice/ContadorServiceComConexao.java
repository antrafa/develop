package br.com.antoniorafael.contadorservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ContadorServiceComConexao extends ContadorService {
    private final IBinder conexao = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return conexao;
    }

    public int count(){
        return count;
    }

    public class LocalBinder extends Binder{
        public ContadorServiceComConexao getContador(){
            return ContadorServiceComConexao.this;
        }
    }
}
