package br.com.antoniorafael.segundoprojeto;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("logs-testes", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("logs-testes","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("logs-testes", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("logs-testes", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("logs-testes", "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("logs-testes", "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("logs-testes", "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.i("logs-testes","Criando Menu");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_novo){
            //chamando uma segunda Activity
            Intent intencao = new Intent(this,SegundaActivity.class);

            //passando parametro para a segunda activity
            intencao.putExtra("mensagem","Texto vindo a activity anterior");

            startActivity(intencao);
            return true;
        }

        if(id == R.id.action_settings){
            Toast.makeText(this,"Clicou no settings",Toast.LENGTH_SHORT).show();
            return true;
        }

        if(id == R.id.action_outros){
            Toast.makeText(this,"Clicou no outros",Toast.LENGTH_SHORT).show();
            return true;
        }

        if(id == R.id.action_finalizar){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
