package br.com.antoniorafael.churrascator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultadoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Churrasco params = (Churrasco) getIntent().getSerializableExtra("churrasco");

        params.setConsumo();

        TextView numeroPessoas = (TextView) findViewById(R.id.numeroPessoas);
        TextView carne = (TextView) findViewById(R.id.carne);
        TextView linguica = (TextView) findViewById(R.id.linguica);
        TextView refrigerante = (TextView) findViewById(R.id.refrigerante);

        numeroPessoas.setText("Número de pessoas: " + params.getPessoas().toString());
        carne.setText("Consumo de carne por pessoa: " + params.getCarne().toString() + "gr");
        linguica.setText("Consumo de linguiça por pessoa: " + params.getLinguica().toString() + "un");
        refrigerante.setText("Consumo de refrigerante por pessoa: " + params.getRefrigerante().toString() + "ml");

        TextView consumoCarne = (TextView) findViewById(R.id.consumoCarne);
        TextView consumoLinguica = (TextView) findViewById(R.id.consumoLinguica);
        TextView consumoRefri = (TextView) findViewById(R.id.consumoRefri);

        consumoCarne.setText("Consumo total de carne: " + params.getConsumoCarne().toString() + "gr");
        consumoLinguica.setText("Consumo total de linguiça: " + params.getConsumoLinguica().toString() + "un");
        consumoRefri.setText("Consumo total de refrigerante: " + params.getConsumoRefrigerante().toString() + "ml");


    }

}
