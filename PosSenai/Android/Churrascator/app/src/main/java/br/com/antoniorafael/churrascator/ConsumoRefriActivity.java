package br.com.antoniorafael.churrascator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;

public class ConsumoRefriActivity extends ActionBarActivity {

    NumberPicker consumoRefri;
    int multiplicador = 100;
    Churrasco params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumo_refri);

        params = (Churrasco) getIntent().getSerializableExtra("churrasco");

        Log.i("logs", params.getCarne().toString());
        Log.i("logs",params.getLinguica().toString());

        consumoRefri = (NumberPicker) findViewById(R.id.consumoRefri);
        consumoRefri.setMinValue(1);
        consumoRefri.setMaxValue(20);

        NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                int temp = value * multiplicador;
                return "" + temp;
            }
        };
        consumoRefri.setFormatter(formatter);

    }

    public void proximo(View tela){

        Integer valor = consumoRefri.getValue() * multiplicador;

        params.setRefrigerante(valor);

        Intent intencao = new Intent(this,NumeroPessoasActivity.class);
        intencao.putExtra("churrasco", params);
        startActivity(intencao);

    }

}
