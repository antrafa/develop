package br.com.antoniorafael.churrascatorpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ResultadoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle params = getIntent().getExtras();

        if(params != null) {
            Integer pessoas = params.getInt("pessoas");

            Calculadora calculadora = new Calculadora();
            calculadora.setPessoas(pessoas);

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

            calculadora.setCarne(Integer.valueOf(preferences.getString("consumo_carne", "300")));
            calculadora.setLinguica(Integer.valueOf(preferences.getString("consumo_linguica", "5")));
            calculadora.setRefrigerante(Integer.valueOf(preferences.getString("consumo_refri", "250")));

            calculadora.setConsumo();

            TextView numeroPessoas = (TextView) findViewById(R.id.numeroPessoas);
            TextView carne = (TextView) findViewById(R.id.carne);
            TextView linguica = (TextView) findViewById(R.id.linguica);
            TextView refrigerante = (TextView) findViewById(R.id.refrigerante);

            numeroPessoas.setText("Número de pessoas: " + calculadora.getPessoas().toString());
            carne.setText("Consumo de carne por pessoa: " + calculadora.getCarne().toString() + " gr");
            linguica.setText("Consumo de linguiça por pessoa: " + calculadora.getLinguica().toString() + " un");
            refrigerante.setText("Consumo de refrigerante por pessoa: " + calculadora.getRefrigerante().toString() + " ml");

            TextView consumoCarne = (TextView) findViewById(R.id.consumoCarne);
            TextView consumoLinguica = (TextView) findViewById(R.id.consumoLinguica);
            TextView consumoRefri = (TextView) findViewById(R.id.consumoRefri);

            consumoCarne.setText("Consumo total de carne: " + calculadora.getConsumoCarne().toString() + " gr");
            consumoLinguica.setText("Consumo total de linguiça: " + calculadora.getConsumoLinguica().toString() + " un");
            consumoRefri.setText("Consumo total de refrigerante: " + calculadora.getConsumoRefrigerante().toString() + " ml");

        }
    }


}
