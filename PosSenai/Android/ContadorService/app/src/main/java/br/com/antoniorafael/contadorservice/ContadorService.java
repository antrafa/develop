package br.com.antoniorafael.contadorservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class ContadorService extends Service implements Runnable {
    private static final int MAX = 1000;
    protected int count;
    private boolean ativo;
    private Handler myHandler = new Handler();

    @Override
    public void onCreate() {
        ativo = true;
        myHandler.post(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void run() {

        if(ativo && count < MAX){

            myHandler.postAtTime(this, SystemClock.uptimeMillis() + 1000);
            Log.i("Teste","Contador service em execução "+count);
            count++;
            return;

        }

        stopSelf();

    }

    @Override
    public void onDestroy() {
        ativo = false;
    }
}
