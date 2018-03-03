package br.com.antoniorafael.apppreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Configurações").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent visualizarConfigs = new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(visualizarConfigs);
                return false;
            }
        });
        return true;
    }

    public void gravar(View tela){

        String nome = ((EditText) findViewById(R.id.nomeCampo)).getText().toString();

        Toast.makeText(this,"Gravando "+nome,Toast.LENGTH_SHORT).show();

        //Passando o contexto
       // SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

       //Passando o nome do arquivo
        SharedPreferences preferences = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);

        //exclusivo da Activity
        //SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("nome", nome);
        editor.commit();

    }

    public void ler(View tela){

        Intent intencao = new Intent(this,SegundaActivity.class);
        startActivity(intencao);

    }
}
