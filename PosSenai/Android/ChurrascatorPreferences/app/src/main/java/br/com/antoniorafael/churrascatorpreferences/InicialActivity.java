package br.com.antoniorafael.churrascatorpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;

public class InicialActivity extends ActionBarActivity {

    NumberPicker numeroPessoas;
    Integer consumoCarne = 0;
    Integer consumoLinguica = 0;
    Integer consumoRefri = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        numeroPessoas = (NumberPicker) findViewById(R.id.numeroPessoas);
        numeroPessoas.setMinValue(1);
        numeroPessoas.setMaxValue(40);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(this,ConfiguracoesActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void proximo(View tela){

        Intent i = new Intent(this,ResultadoActivity.class);
        i.putExtra("pessoas", numeroPessoas.getValue());
        startActivity(i);

    }

}
