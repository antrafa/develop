package br.com.antoniorafael.contadorservice;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InicialActivity extends Activity implements ServiceConnection {

    private ContadorServiceComConexao contador;
    final ServiceConnection conexao = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        //final Intent intent = new Intent(this, ContadorService.class);

        Button iniciar = (Button) findViewById(R.id.iniciar);
        iniciar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(InicialActivity.this, ContadorServiceComConexao.class));
                bindService(new Intent(InicialActivity.this, ContadorServiceComConexao.class), conexao, Context.BIND_AUTO_CREATE);

            }
        });

        Button parar = (Button) findViewById(R.id.parar);
        parar.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                //stopService(intent);

                unbindService(conexao);
            }
        });

        Button visualizar = (Button) findViewById(R.id.visualizar);
        visualizar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = contador.count();
                Toast.makeText(InicialActivity.this,"C: "+ count,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(conexao);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
