package br.com.antoniorafael.torico;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InicialActivity extends Activity {//AppCompatActivity

    private Button iniciar;
    private Button parar;
    private Button pausar;
    private Servico contador;
    private Handler handler = new InicialHandler();

    private ServiceConnection conexao = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Servico.LocalBinder binder = (Servico.LocalBinder) service;
            contador = binder.getServico();
            if(contador.getAtivo()){//servico já ativo, desativa botão iniciar
                iniciar.setEnabled(false);
                parar.setEnabled(true);
                pausar.setEnabled(true);
            }
            contador.setHandler(handler);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            contador = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        iniciar = (Button) findViewById(R.id.btniniciar);
        parar = (Button) findViewById(R.id.btnparar);
        pausar = (Button) findViewById(R.id.btnpausar);
        startService(new Intent(this, Servico.class));
    }

    //onResume. Conecta-se ao serviço
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Teste", "Resume");
        bindService(new Intent(this, Servico.class), conexao, Context.BIND_AUTO_CREATE);
    }

    //Parou a aplicação. Tira o vinculo do servico, que será refeito no onResume
    @Override
    protected void onPause() {
        super.onPause();
        unbindService(conexao);
    }

    //Criando o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicial, menu);
        return true;
    }

    //Identificando o click no menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(this, PreferenciasActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void iniciar(View v){
        contador.iniciar();
        iniciar.setEnabled(false);
        parar.setEnabled(true);
        pausar.setEnabled(true);
    }

    public void pausar(View v){
        contador.pausar();
        iniciar.setEnabled(true);
        parar.setEnabled(true);
        pausar.setEnabled(false);
    }

    public void parar(View v){
        contador.parar();
        iniciar.setEnabled(true);
        parar.setEnabled(false);
        pausar.setEnabled(false);
    }

    //Handler para ser passado ao serviço, no ServiceConnection que vai atualizar a view
    public class InicialHandler extends Handler{
        public void handleMessage(Message msg){
            ((TextView) findViewById(R.id.tempo_trabalhado)).setText(msg.getData().getString("tempo"));
            ((TextView) findViewById(R.id.valor_hora)).setText(msg.getData().getString("valor_hora"));
            ((TextView) findViewById(R.id.to_rico)).setText(msg.getData().getString("ganho"));
        }
    }

}
